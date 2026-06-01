package org.heinrich10.controllers;

import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import org.heinrich10.responses.CountryResponse;
import org.heinrich10.services.CountryService;

import java.util.Optional;

@ExecuteOn(TaskExecutors.BLOCKING)
@Controller("/countries")
public class CountryController {

    protected final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @Get("/{code}")
    public Optional<CountryResponse> getOne(String code) {
        return countryService.findById(code);
    }

    @Get("/")
    public Page<CountryResponse> getAll(
            @QueryValue(defaultValue = "0") Integer page,
            @QueryValue(defaultValue = "10") Integer size
    ) {
        Pageable pageable = Pageable.from(page, size);
        return countryService.findAll(pageable);
    }
}
