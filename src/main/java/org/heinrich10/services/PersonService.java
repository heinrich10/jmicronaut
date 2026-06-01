package org.heinrich10.services;

import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import jakarta.inject.Singleton;
import org.heinrich10.models.Person;
import org.heinrich10.repositories.PersonRepository;
import org.heinrich10.requests.CreatePersonRequest;
import org.heinrich10.requests.UpdatePersonRequest;
import org.heinrich10.responses.PersonResponse;

import java.util.Optional;

@Singleton
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Optional<PersonResponse> findById(Long id) {
        return personRepository.findById(id).map(this::toResponse);
    }

    public Page<PersonResponse> findAll(Pageable pageable) {
        return personRepository.findAll(pageable).map(this::toResponse);
    }

    public PersonResponse create(CreatePersonRequest request) {
        Person person = new Person(null, request.getFirstName(), request.getLastName(), request.getCountryCode());
        Person saved = personRepository.save(person);
        return toResponse(saved);
    }

    public void update(Long id, UpdatePersonRequest request) {
        Person person = new Person(id, request.getFirstName(), request.getLastName(), request.getCountryCode());
        personRepository.update(person);
    }

    private PersonResponse toResponse(Person person) {
        return new PersonResponse(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getCountryCode(),
                person.getCreatedAt(),
                person.getUpdatedAt()
        );
    }
}
