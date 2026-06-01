package org.heinrich10.controllers;

import io.micronaut.core.type.Argument;
import io.micronaut.data.model.Page;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.heinrich10.responses.CountryResponse;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
public class CountryControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void testGetCountries() {
        Page<CountryResponse> page = client.toBlocking().retrieve(
                HttpRequest.GET("/countries"), Argument.of(Page.class, CountryResponse.class));
        assertNotNull(page);
        assertFalse(page.getContent().isEmpty());
    }

    @Test
    void testGetOne() {
        Optional<CountryResponse> country = client.toBlocking().retrieve(
                HttpRequest.GET("/countries/US"), Argument.of(Optional.class, CountryResponse.class));
        assertTrue(country.isPresent());
        assertEquals("United States", country.get().name());
    }

    @Test
    void testGetOne404() {
        HttpClientResponseException exception = assertThrows(HttpClientResponseException.class, () -> {
            client.toBlocking().retrieve(
                    HttpRequest.GET("/countries/ZZ"), Argument.of(Optional.class, CountryResponse.class));
        });

        assertNotNull(exception.getResponse());
        assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());
    }
}
