package org.heinrich10.controllers;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.heinrich10.dto.responses.ContinentResponse;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
public class ContinentControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void testGetContinents() {
        List<ContinentResponse> res = client.toBlocking().retrieve(
                HttpRequest.GET("/continents"), Argument.of(List.class, ContinentResponse.class));
        assertNotNull(res);
        assertFalse(res.isEmpty());
        assertEquals(7, res.size());
    }

    @Test
    void testGetOne() {
        Optional<ContinentResponse> continent = client.toBlocking().retrieve(
                HttpRequest.GET("/continents/EU"), Argument.of(Optional.class, ContinentResponse.class));
        assertTrue(continent.isPresent());
        assertEquals("Europe", continent.get().name());
    }

    @Test
    void testGetOne404() {
        HttpClientResponseException exception = assertThrows(HttpClientResponseException.class, () -> {
            client.toBlocking().retrieve(
                    HttpRequest.GET("/continents/ZZ"), Argument.of(Optional.class, ContinentResponse.class));
        });

        assertNotNull(exception.getResponse());
        assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());
    }
}
