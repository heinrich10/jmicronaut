package org.heinrich10;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest
class InfoEndpointTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void infoEndpointReturnsOk() {
        var response = client.toBlocking().exchange(
                HttpRequest.GET("/info"),
                Map.class
        );

        assertEquals(HttpStatus.OK, response.getStatus());
        assertNotNull(response.getBody());
    }
}
