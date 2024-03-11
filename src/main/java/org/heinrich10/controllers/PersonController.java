package org.heinrich10.controllers;

import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import jakarta.validation.Valid;
import org.heinrich10.models.Person;
import org.heinrich10.repositories.PersonRepository;
import org.heinrich10.requests.CreatePersonRequest;
import org.heinrich10.requests.UpdatePersonRequest;

import java.util.Optional;

@ExecuteOn(TaskExecutors.BLOCKING)
@Controller("/persons")
public class PersonController {

    protected final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Get("/{id}")
    public Optional<Person> getOne(Long id) {
        return personRepository.findById(id);
    }

    @Get("/")
    public Page<Person> getAll(
            @QueryValue(defaultValue = "0") Integer page,
            @QueryValue(defaultValue = "10") Integer size
    ) {
        return personRepository.findAll(Pageable.from(page, size));
    }

    @Post("/")
    public Person create(@Body @Valid CreatePersonRequest personRequest) {
        return personRepository.save(personRequest.toPerson());
    }

    @Put("/{id}")
    public HttpResponse<String> update(Long id, @Body @Valid UpdatePersonRequest personRequest) {
        personRepository.update(personRequest.toPerson(id));
        return HttpResponse.noContent();
    }
}
