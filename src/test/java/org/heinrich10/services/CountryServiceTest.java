package org.heinrich10.services;

import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import org.heinrich10.dto.responses.CountryResponse;
import org.heinrich10.models.Country;
import org.heinrich10.repositories.CountryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.Instant;
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
    void findByIdReturnsCountryWhenFound() {
        Country country = new Country();
        country.setCode("US");
        country.setName("United States");
        country.setPhone(1);
        country.setSymbol("$");
        country.setCapital("Washington, D.C.");
        country.setCurrency("USD");
        country.setContinentCode("NA");
        country.setAlpha3("USA");
        country.setCreatedAt(Timestamp.from(Instant.now()));
        country.setUpdatedAt(Timestamp.from(Instant.now()));
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
        verify(countryRepository).findById("US");
    }

    @Test
    void findByIdReturnsEmptyWhenNotFound() {
        when(countryRepository.findById("ZZ")).thenReturn(Optional.empty());

        Optional<CountryResponse> result = countryService.findById("ZZ");

        assertTrue(result.isEmpty());
        verify(countryRepository).findById("ZZ");
    }

    @Test
    void findAllReturnsPageOfResponses() {
        Country country = new Country();
        country.setCode("CA");
        country.setName("Canada");
        country.setPhone(1);
        country.setSymbol("C$");
        country.setCapital("Ottawa");
        country.setCurrency("CAD");
        country.setContinentCode("NA");
        country.setAlpha3("CAN");
        country.setCreatedAt(Timestamp.from(Instant.now()));
        country.setUpdatedAt(Timestamp.from(Instant.now()));
        Pageable pageable = Pageable.from(0, 10);
        Page<Country> countryPage = Page.of(List.of(country), pageable, 1L);
        when(countryRepository.findAll(pageable)).thenReturn(countryPage);

        Page<CountryResponse> result = countryService.findAll(pageable);

        assertNotNull(result);
        assertEquals(1, result.getTotalSize());
        assertEquals(1, result.getContent().size());
        assertEquals("CA", result.getContent().get(0).code());
        assertEquals("Canada", result.getContent().get(0).name());
        verify(countryRepository).findAll(pageable);
    }
}
