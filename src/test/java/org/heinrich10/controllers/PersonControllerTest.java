package org.heinrich10.controllers;

import io.micronaut.core.type.Argument;
import io.micronaut.data.model.Page;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.flywaydb.core.Flyway;
import org.heinrich10.dto.requests.CreatePersonRequest;
import org.heinrich10.dto.requests.UpdatePersonRequest;
import org.heinrich10.dto.responses.PersonResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
public class PersonControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Inject
    Flyway flyway;

    @BeforeEach
    void setup() {
        flyway.clean();
        flyway.migrate();
    }

    private static final long UNKNOWN_PERSON_ID = 999_999L;

    @Test
    void testGetAll() {
        Page<PersonResponse> page = client.toBlocking().retrieve(HttpRequest.GET("/persons"), Argument.of(Page.class, PersonResponse.class));
        assertNotNull(page);
        assertFalse(page.getContent().isEmpty());
    }

    @Test
    void testGetOne404() {
        HttpClientResponseException exception = assertThrows(HttpClientResponseException.class, () -> {
            client.toBlocking().retrieve(HttpRequest.GET("/persons/" + UNKNOWN_PERSON_ID), Argument.of(Optional.class, PersonResponse.class));
        });
        assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());
    }

    @Test
    void testCreateWithBlankFirstName() {
        CreatePersonRequest invalid = new CreatePersonRequest("", "Doe", "US");
        HttpClientResponseException exception = assertThrows(HttpClientResponseException.class, () -> {
            client.toBlocking().retrieve(HttpRequest.POST("/persons", invalid), PersonResponse.class);
        });
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());
    }

    @Nested
    @DisplayName("when a person has been created")
    class WhenPersonExists {

        private Long personId;

        @BeforeEach
        void createPerson() {
            CreatePersonRequest create = new CreatePersonRequest("John", "Doe", "US");
            HttpResponse<PersonResponse> response = client.toBlocking().exchange(HttpRequest.POST("/persons", create), PersonResponse.class);
            assertEquals(HttpStatus.CREATED, response.getStatus());
            PersonResponse person = response.body();
            assertNotNull(person);
            assertNotNull(person.id());
            personId = person.id();
        }

        @Test
        @DisplayName("should retrieve the created person")
        void testRetrieve() {
            Optional<PersonResponse> personOpt = client.toBlocking().retrieve(
                    HttpRequest.GET("/persons/" + personId), Argument.of(Optional.class, PersonResponse.class));
            assertTrue(personOpt.isPresent());
            PersonResponse person = personOpt.get();
            assertEquals(personId, person.id());
            assertEquals("John", person.firstName());
            assertEquals("Doe", person.lastName());
            assertEquals("US", person.countryCode());
        }

        @Test
        @DisplayName("should update the person")
        void testUpdate() {
            UpdatePersonRequest update = new UpdatePersonRequest("Jane", "Smith", "CA");
            HttpResponse<Void> response = client.toBlocking().exchange(
                    HttpRequest.PUT("/persons/" + personId, update), Void.class);
            assertEquals(HttpStatus.NO_CONTENT, response.getStatus());

            Optional<PersonResponse> personOpt = client.toBlocking().retrieve(
                    HttpRequest.GET("/persons/" + personId), Argument.of(Optional.class, PersonResponse.class));
            assertTrue(personOpt.isPresent());
            PersonResponse person = personOpt.get();
            assertEquals("Jane", person.firstName());
            assertEquals("Smith", person.lastName());
            assertEquals("CA", person.countryCode());
        }
    }
}
