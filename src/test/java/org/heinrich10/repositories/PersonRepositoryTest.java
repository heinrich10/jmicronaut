package org.heinrich10.repositories;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.heinrich10.models.Person;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
public class PersonRepositoryTest {

    @Inject
    PersonRepository personRepository;

    @Test
    void testCrud() {
        Person person = new Person(null, "John", "Doe", "US");
        person = personRepository.save(person);
        assertNotNull(person.getId());

        Optional<Person> found = personRepository.findById(person.getId());
        assertTrue(found.isPresent());
        assertEquals("John", found.get().getFirstName());

        person.setFirstName("Jane");
        personRepository.update(person);

        found = personRepository.findById(person.getId());
        assertTrue(found.isPresent());
        assertEquals("Jane", found.get().getFirstName());

        personRepository.delete(person);
        found = personRepository.findById(person.getId());
        assertFalse(found.isPresent());
    }
}
