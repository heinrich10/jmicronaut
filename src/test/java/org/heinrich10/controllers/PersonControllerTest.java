package org.heinrich10.controllers;

import io.micronaut.core.type.Argument;
import io.micronaut.data.model.Page;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.flywaydb.core.Flyway;
import org.heinrich10.models.Person;
import org.heinrich10.requests.CreatePersonRequest;
import org.heinrich10.requests.UpdatePersonRequest;
import org.junit.jupiter.api.BeforeEach;
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

    @Test
    void testPersonLifecycle() {
        // Create
        CreatePersonRequest create = new CreatePersonRequest("John", "Doe", "US");
        Person person = client.toBlocking().retrieve(HttpRequest.POST("/persons", create), Person.class);

        assertNotNull(person);
        assertNotNull(person.getId());
        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());
        assertEquals("US", person.getCountryCode());

        Long id = person.getId();

        // Get One
        Optional<Person> personOpt = client.toBlocking().retrieve(HttpRequest.GET("/persons/" + id), Argument.of(Optional.class, Person.class));
        assertTrue(personOpt.isPresent());
        person = personOpt.get();
        assertEquals(id, person.getId());

        // Update
        UpdatePersonRequest update = new UpdatePersonRequest("Jane", "Smith", "CA");
        HttpResponse<String> response = client.toBlocking().exchange(HttpRequest.PUT("/persons/" + id, update), String.class);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatus());

        // Get One again
        personOpt = client.toBlocking().retrieve(HttpRequest.GET("/persons/" + id), Argument.of(Optional.class, Person.class));
        person = personOpt.get();
        assertEquals("Jane", person.getFirstName());
        assertEquals("Smith", person.getLastName());
        assertEquals("CA", person.getCountryCode());
    }

    @Test
    void testGetAll() {
        Page<Person> page = client.toBlocking().retrieve(HttpRequest.GET("/persons"), Argument.of(Page.class, Person.class));
        assertNotNull(page);
        assertFalse(page.getContent().isEmpty());
    }
}
