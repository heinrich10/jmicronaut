package org.heinrich10.services;

import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import org.heinrich10.dto.requests.CreatePersonRequest;
import org.heinrich10.dto.requests.UpdatePersonRequest;
import org.heinrich10.dto.responses.PersonResponse;
import org.heinrich10.models.Person;
import org.heinrich10.repositories.PersonRepository;
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

class PersonServiceTest {

    private PersonRepository personRepository;
    private PersonService personService;

    @BeforeEach
    void setUp() {
        personRepository = mock(PersonRepository.class);
        personService = new PersonService(personRepository);
    }

    @Test
    @DisplayName("should return person with timestamps when found by id")
    void findByIdReturnsPersonWhenFound() {
        Timestamp createdAt = Timestamp.from(Instant.now());
        Timestamp updatedAt = Timestamp.from(Instant.now());
        Person person = person(1L, "John", "Doe", "US", createdAt, updatedAt);
        when(personRepository.findById(1L)).thenReturn(Optional.of(person));

        Optional<PersonResponse> result = personService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().id());
        assertEquals("John", result.get().firstName());
        assertEquals("Doe", result.get().lastName());
        assertEquals("US", result.get().countryCode());
        assertEquals(createdAt, result.get().createdAt());
        assertEquals(updatedAt, result.get().updatedAt());
        verify(personRepository).findById(1L);
    }

    @Test
    @DisplayName("should return empty optional when person not found")
    void findByIdReturnsEmptyWhenNotFound() {
        when(personRepository.findById(999L)).thenReturn(Optional.empty());

        Optional<PersonResponse> result = personService.findById(999L);

        assertTrue(result.isEmpty());
        verify(personRepository).findById(999L);
    }

    @Test
    @DisplayName("should propagate exception when repository findById fails")
    void findByIdPropagatesException() {
        RuntimeException dbError = new RuntimeException("DB down");
        when(personRepository.findById(1L)).thenThrow(dbError);

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            personService.findById(1L);
        });
        assertEquals("DB down", thrown.getMessage());
    }

    @Test
    @DisplayName("should return page of person responses with timestamps")
    void findAllReturnsPageOfResponses() {
        Timestamp createdAt = Timestamp.from(Instant.now());
        Timestamp updatedAt = Timestamp.from(Instant.now());
        Person person = person(1L, "Jane", "Doe", "CA", createdAt, updatedAt);
        Pageable pageable = Pageable.from(0, 10);
        Page<Person> personPage = Page.of(List.of(person), pageable, 1L);
        when(personRepository.findAll(pageable)).thenReturn(personPage);

        Page<PersonResponse> result = personService.findAll(pageable);

        assertNotNull(result);
        assertEquals(1, result.getTotalSize());
        assertEquals(1, result.getContent().size());
        PersonResponse first = result.getContent().get(0);
        assertEquals("Jane", first.firstName());
        assertEquals(createdAt, first.createdAt());
        assertEquals(updatedAt, first.updatedAt());
        verify(personRepository).findAll(pageable);
    }

    @Test
    @DisplayName("should return empty page when no persons exist")
    void findAllReturnsEmptyPage() {
        Pageable pageable = Pageable.from(0, 10);
        Page<Person> emptyPage = Page.of(Collections.emptyList(), pageable, 0L);
        when(personRepository.findAll(pageable)).thenReturn(emptyPage);

        Page<PersonResponse> result = personService.findAll(pageable);

        assertNotNull(result);
        assertEquals(0, result.getTotalSize());
        assertTrue(result.getContent().isEmpty());
        verify(personRepository).findAll(pageable);
    }

    @Test
    @DisplayName("should save person and return response with timestamps")
    void createSavesAndReturnsResponse() {
        CreatePersonRequest request = new CreatePersonRequest("Alice", "Smith", "GB");
        Timestamp createdAt = Timestamp.from(Instant.now());
        Timestamp updatedAt = Timestamp.from(Instant.now());
        Person saved = person(1L, "Alice", "Smith", "GB", createdAt, updatedAt);
        when(personRepository.save(any(Person.class))).thenReturn(saved);

        PersonResponse result = personService.create(request);

        assertNotNull(result);
        assertEquals(1L, result.id());
        assertEquals("Alice", result.firstName());
        assertEquals("Smith", result.lastName());
        assertEquals("GB", result.countryCode());
        assertEquals(createdAt, result.createdAt());
        assertEquals(updatedAt, result.updatedAt());
        verify(personRepository).save(any(Person.class));
    }

    @Test
    @DisplayName("should propagate exception when repository save fails")
    void createPropagatesException() {
        CreatePersonRequest request = new CreatePersonRequest("Alice", "Smith", "GB");
        RuntimeException dbError = new RuntimeException("DB down");
        when(personRepository.save(any(Person.class))).thenThrow(dbError);

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            personService.create(request);
        });
        assertEquals("DB down", thrown.getMessage());
    }

    @Test
    @DisplayName("should map request to entity and call repository update")
    void updateCallsRepositoryUpdate() {
        UpdatePersonRequest request = new UpdatePersonRequest("Bob", "Brown", "AU");

        personService.update(1L, request);

        // Verifies that the service correctly maps the request fields onto a Person entity
        verify(personRepository).update(argThat(p ->
                p.getId().equals(1L) &&
                p.getFirstName().equals("Bob") &&
                p.getLastName().equals("Brown") &&
                p.getCountryCode().equals("AU")
        ));
    }

    @Test
    @DisplayName("should propagate exception when repository update fails")
    void updatePropagatesException() {
        UpdatePersonRequest request = new UpdatePersonRequest("Bob", "Brown", "AU");
        RuntimeException dbError = new RuntimeException("DB down");
        doThrow(dbError).when(personRepository).update(any(Person.class));

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            personService.update(1L, request);
        });
        assertEquals("DB down", thrown.getMessage());
    }

    private Person person(Long id, String firstName, String lastName, String countryCode,
                          Timestamp createdAt, Timestamp updatedAt) {
        Person person = new Person(id, firstName, lastName, countryCode);
        person.setCreatedAt(createdAt);
        person.setUpdatedAt(updatedAt);
        return person;
    }
}
