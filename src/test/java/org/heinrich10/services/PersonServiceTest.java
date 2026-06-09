package org.heinrich10.services;

import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import org.heinrich10.dto.requests.CreatePersonRequest;
import org.heinrich10.dto.requests.UpdatePersonRequest;
import org.heinrich10.dto.responses.PersonResponse;
import org.heinrich10.models.Person;
import org.heinrich10.repositories.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.Instant;
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
    void findByIdReturnsPersonWhenFound() {
        Person person = new Person(1L, "John", "Doe", "US");
        person.setCreatedAt(Timestamp.from(Instant.now()));
        person.setUpdatedAt(Timestamp.from(Instant.now()));
        when(personRepository.findById(1L)).thenReturn(Optional.of(person));

        Optional<PersonResponse> result = personService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().id());
        assertEquals("John", result.get().firstName());
        assertEquals("Doe", result.get().lastName());
        assertEquals("US", result.get().countryCode());
        verify(personRepository).findById(1L);
    }

    @Test
    void findByIdReturnsEmptyWhenNotFound() {
        when(personRepository.findById(999L)).thenReturn(Optional.empty());

        Optional<PersonResponse> result = personService.findById(999L);

        assertTrue(result.isEmpty());
        verify(personRepository).findById(999L);
    }

    @Test
    void findAllReturnsPageOfResponses() {
        Person person = new Person(1L, "Jane", "Doe", "CA");
        Pageable pageable = Pageable.from(0, 10);
        Page<Person> personPage = Page.of(List.of(person), pageable, 1L);
        when(personRepository.findAll(pageable)).thenReturn(personPage);

        Page<PersonResponse> result = personService.findAll(pageable);

        assertNotNull(result);
        assertEquals(1, result.getTotalSize());
        assertEquals(1, result.getContent().size());
        assertEquals("Jane", result.getContent().get(0).firstName());
        verify(personRepository).findAll(pageable);
    }

    @Test
    void createSavesAndReturnsResponse() {
        CreatePersonRequest request = new CreatePersonRequest("Alice", "Smith", "GB");
        Person saved = new Person(1L, "Alice", "Smith", "GB");
        saved.setCreatedAt(Timestamp.from(Instant.now()));
        saved.setUpdatedAt(Timestamp.from(Instant.now()));
        when(personRepository.save(any(Person.class))).thenReturn(saved);

        PersonResponse result = personService.create(request);

        assertNotNull(result);
        assertEquals(1L, result.id());
        assertEquals("Alice", result.firstName());
        assertEquals("Smith", result.lastName());
        assertEquals("GB", result.countryCode());
        verify(personRepository).save(any(Person.class));
    }

    @Test
    void updateCallsRepositoryUpdate() {
        UpdatePersonRequest request = new UpdatePersonRequest("Bob", "Brown", "AU");

        personService.update(1L, request);

        verify(personRepository).update(argThat(p ->
                p.getId().equals(1L) &&
                p.getFirstName().equals("Bob") &&
                p.getLastName().equals("Brown") &&
                p.getCountryCode().equals("AU")
        ));
    }
}
