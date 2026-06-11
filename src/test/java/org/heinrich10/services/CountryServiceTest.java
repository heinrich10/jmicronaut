package org.heinrich10.services;

import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import org.heinrich10.dto.responses.CountryResponse;
import org.heinrich10.models.Country;
import org.heinrich10.repositories.CountryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CountryServiceTest {

    private CountryRepository countryRepository;
    private CountryService countryService;

    @BeforeEach
    void setUp() {
        countryRepository = mock(CountryRepository.class);
        countryService = new CountryService(countryRepository);
    }

    @Test
    @DisplayName("should return country with timestamps when found by id")
    void findByIdReturnsCountryWhenFound() {
        Timestamp createdAt = Timestamp.from(Instant.now());
        Timestamp updatedAt = Timestamp.from(Instant.now());
        Country country = country("US", "United States", "USA", createdAt, updatedAt);
        when(countryRepository.findById("US")).thenReturn(Optional.of(country));

        Optional<CountryResponse> result = countryService.findById("US");

        assertTrue(result.isPresent());
        assertEquals("US", result.get().code());
        assertEquals("United States", result.get().name());
        assertEquals(1, result.get().phone());
        assertEquals("$", result.get().symbol());
        assertEquals("Washington, D.C.", result.get().capital());
        assertEquals("USD", result.get().currency());
        assertEquals("NA", result.get().continentCode());
        assertEquals("USA", result.get().alpha3());
        assertEquals(createdAt, result.get().createdAt());
        assertEquals(updatedAt, result.get().updatedAt());
        verify(countryRepository).findById("US");
    }

    @Test
    @DisplayName("should return empty optional when country not found")
    void findByIdReturnsEmptyWhenNotFound() {
        when(countryRepository.findById("ZZ")).thenReturn(Optional.empty());

        Optional<CountryResponse> result = countryService.findById("ZZ");

        assertTrue(result.isEmpty());
        verify(countryRepository).findById("ZZ");
    }

    @Test
    @DisplayName("should propagate exception when repository findById fails")
    void findByIdPropagatesException() {
        RuntimeException dbError = new RuntimeException("DB down");
        when(countryRepository.findById("US")).thenThrow(dbError);

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            countryService.findById("US");
        });
        assertEquals("DB down", thrown.getMessage());
    }

    @Test
    @DisplayName("should return page of country responses")
    void findAllReturnsPageOfResponses() {
        Timestamp createdAt = Timestamp.from(Instant.now());
        Timestamp updatedAt = Timestamp.from(Instant.now());
        Country country = country("CA", "Canada", "CAN", createdAt, updatedAt);
        Pageable pageable = Pageable.from(0, 10);
        Page<Country> countryPage = Page.of(List.of(country), pageable, 1L);
        when(countryRepository.findAll(pageable)).thenReturn(countryPage);

        Page<CountryResponse> result = countryService.findAll(pageable);

        assertNotNull(result);
        assertEquals(1, result.getTotalSize());
        assertEquals(1, result.getContent().size());
        CountryResponse first = result.getContent().get(0);
        assertEquals("CA", first.code());
        assertEquals("Canada", first.name());
        assertEquals(createdAt, first.createdAt());
        assertEquals(updatedAt, first.updatedAt());
        verify(countryRepository).findAll(pageable);
    }

    @Test
    @DisplayName("should return empty page when no countries exist")
    void findAllReturnsEmptyPage() {
        Pageable pageable = Pageable.from(0, 10);
        Page<Country> emptyPage = Page.of(Collections.emptyList(), pageable, 0L);
        when(countryRepository.findAll(pageable)).thenReturn(emptyPage);

        Page<CountryResponse> result = countryService.findAll(pageable);

        assertNotNull(result);
        assertEquals(0, result.getTotalSize());
        assertTrue(result.getContent().isEmpty());
        verify(countryRepository).findAll(pageable);
    }

    private Country country(String code, String name, String alpha3, Timestamp createdAt, Timestamp updatedAt) {
        Country country = new Country();
        country.setCode(code);
        country.setName(name);
        country.setPhone(1);
        country.setSymbol("$");
        country.setCapital("Washington, D.C.");
        country.setCurrency("USD");
        country.setContinentCode("NA");
        country.setAlpha3(alpha3);
        country.setCreatedAt(createdAt);
        country.setUpdatedAt(updatedAt);
        return country;
    }
}
