package org.heinrich10.controllers;

import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import org.heinrich10.models.Country;
import org.heinrich10.repositories.CountryRepository;

import java.util.Optional;

@ExecuteOn(TaskExecutors.BLOCKING)
@Controller("/countries")
public class CountryController {

    protected final CountryRepository countryRepository;

    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Get("/{code}")
    public Optional<Country> getOne(String code) {
        return countryRepository.findById(code);
    }

    @Get("/")
    public Page<Country> getAll(
            @QueryValue(defaultValue = "0") Integer page,
            @QueryValue(defaultValue = "10") Integer size
    ) {
        Pageable pageable = Pageable.from(page, size);

        return countryRepository.findAll(pageable);
    }
}
