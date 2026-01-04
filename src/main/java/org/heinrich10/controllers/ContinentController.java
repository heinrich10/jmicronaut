package org.heinrich10.controllers;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import org.heinrich10.models.Continent;
import org.heinrich10.repositories.ContinentRepository;

import java.util.Optional;

@ExecuteOn(TaskExecutors.BLOCKING)
@Controller("/continents")
public class ContinentController {

    protected final ContinentRepository continentRepository;

    public ContinentController(ContinentRepository continentRepository) {
        this.continentRepository = continentRepository;
    }

    @Get("/{code}")
    public Optional<Continent> getOne(String code) {
        return continentRepository.findById(code);
    }

    @Get("/")
    public Iterable<Continent> getAll() {
        return continentRepository.findAll();
    }
}
