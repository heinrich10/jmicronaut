package org.heinrich10.controllers;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import jakarta.inject.Inject;
import org.heinrich10.dto.responses.ContinentResponse;
import org.heinrich10.services.ContinentService;

import java.util.List;
import java.util.Optional;

@ExecuteOn(TaskExecutors.BLOCKING)
@Controller("/continents")
public class ContinentController {

    private final ContinentService continentService;

    @Inject
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
