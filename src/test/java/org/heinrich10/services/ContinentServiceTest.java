package org.heinrich10.services;

import org.heinrich10.dto.responses.ContinentResponse;
import org.heinrich10.models.Continent;
import org.heinrich10.repositories.ContinentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ContinentServiceTest {

    private ContinentRepository continentRepository;
    private ContinentService continentService;

    @BeforeEach
    void setUp() {
        continentRepository = mock(ContinentRepository.class);
        continentService = new ContinentService(continentRepository);
    }

    @Test
    @DisplayName("should return continent when found by id")
    void findByIdReturnsContinentWhenFound() {
        Continent continent = continent("EU", "Europe");
        when(continentRepository.findById("EU")).thenReturn(Optional.of(continent));

        Optional<ContinentResponse> result = continentService.findById("EU");

        assertTrue(result.isPresent());
        assertEquals("EU", result.get().code());
        assertEquals("Europe", result.get().name());
        verify(continentRepository).findById("EU");
    }

    @Test
    @DisplayName("should return empty optional when continent not found")
    void findByIdReturnsEmptyWhenNotFound() {
        when(continentRepository.findById("ZZ")).thenReturn(Optional.empty());

        Optional<ContinentResponse> result = continentService.findById("ZZ");

        assertTrue(result.isEmpty());
        verify(continentRepository).findById("ZZ");
    }

    @Test
    @DisplayName("should propagate exception when repository findById fails")
    void findByIdPropagatesException() {
        RuntimeException dbError = new RuntimeException("DB down");
        when(continentRepository.findById("EU")).thenThrow(dbError);

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            continentService.findById("EU");
        });
        assertEquals("DB down", thrown.getMessage());
    }

    @Test
    @DisplayName("should return list of continent responses")
    void findAllReturnsListOfResponses() {
        Continent europe = continent("EU", "Europe");
        Continent asia = continent("AS", "Asia");
        when(continentRepository.findAll()).thenReturn(List.of(europe, asia));

        List<ContinentResponse> result = continentService.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("EU", result.get(0).code());
        assertEquals("Europe", result.get(0).name());
        assertEquals("AS", result.get(1).code());
        assertEquals("Asia", result.get(1).name());
        verify(continentRepository).findAll();
    }

    @Test
    @DisplayName("should return empty list when no continents exist")
    void findAllReturnsEmptyList() {
        when(continentRepository.findAll()).thenReturn(Collections.emptyList());

        List<ContinentResponse> result = continentService.findAll();

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(continentRepository).findAll();
    }

    private Continent continent(String code, String name) {
        Continent continent = new Continent();
        continent.setCode(code);
        continent.setName(name);
        return continent;
    }
}
