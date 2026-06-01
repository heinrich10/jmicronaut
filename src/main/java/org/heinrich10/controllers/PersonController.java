package org.heinrich10.controllers;

import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import jakarta.validation.Valid;
import org.heinrich10.requests.CreatePersonRequest;
import org.heinrich10.requests.UpdatePersonRequest;
import org.heinrich10.responses.PersonResponse;
import org.heinrich10.services.PersonService;

import java.net.URI;
import java.util.Optional;

@ExecuteOn(TaskExecutors.BLOCKING)
@Controller("/persons")
public class PersonController {

    protected final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @Get("/{id}")
    public Optional<PersonResponse> getOne(Long id) {
        return personService.findById(id);
    }

    @Get("/")
    public Page<PersonResponse> getAll(
            @QueryValue(defaultValue = "0") Integer page,
            @QueryValue(defaultValue = "10") Integer size
    ) {
        return personService.findAll(Pageable.from(page, size));
    }

    @Post("/")
    public HttpResponse<PersonResponse> create(@Body @Valid CreatePersonRequest personRequest) {
        PersonResponse response = personService.create(personRequest);
        return HttpResponse.created(response, URI.create("/persons/" + response.id()));
    }

    @Put("/{id}")
    public HttpResponse<Void> update(Long id, @Body @Valid UpdatePersonRequest personRequest) {
        personService.update(id, personRequest);
        return HttpResponse.noContent();
    }
}
