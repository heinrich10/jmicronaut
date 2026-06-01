package org.heinrich10.controllers;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import org.heinrich10.responses.ContinentResponse;
import org.heinrich10.services.ContinentService;

import java.util.List;
import java.util.Optional;

@ExecuteOn(TaskExecutors.BLOCKING)
@Controller("/continents")
public class ContinentController {

    protected final ContinentService continentService;

    public ContinentController(ContinentService continentService) {
        this.continentService = continentService;
    }

    @Get("/{code}")
    public Optional<ContinentResponse> getOne(String code) {
        return continentService.findById(code);
    }

    @Get("/")
    public List<ContinentResponse> getAll() {
        return continentService.findAll();
    }
}
