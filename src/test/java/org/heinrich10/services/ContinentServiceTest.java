package org.heinrich10.services;

import org.heinrich10.dto.responses.ContinentResponse;
import org.heinrich10.models.Continent;
import org.heinrich10.repositories.ContinentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void findByIdReturnsContinentWhenFound() {
        Continent continent = new Continent();
        continent.setCode("EU");
        continent.setName("Europe");
        when(continentRepository.findById("EU")).thenReturn(Optional.of(continent));

        Optional<ContinentResponse> result = continentService.findById("EU");

        assertTrue(result.isPresent());
        assertEquals("EU", result.get().code());
        assertEquals("Europe", result.get().name());
        verify(continentRepository).findById("EU");
    }

    @Test
    void findByIdReturnsEmptyWhenNotFound() {
        when(continentRepository.findById("ZZ")).thenReturn(Optional.empty());

        Optional<ContinentResponse> result = continentService.findById("ZZ");

        assertTrue(result.isEmpty());
        verify(continentRepository).findById("ZZ");
    }

    @Test
    void findAllReturnsListOfResponses() {
        Continent europe = new Continent();
        europe.setCode("EU");
        europe.setName("Europe");
        Continent asia = new Continent();
        asia.setCode("AS");
        asia.setName("Asia");
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
}
