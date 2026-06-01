package org.heinrich10.services;

import jakarta.inject.Singleton;
import org.heinrich10.models.Continent;
import org.heinrich10.repositories.ContinentRepository;
import org.heinrich10.responses.ContinentResponse;

import java.util.List;
import java.util.Optional;

@Singleton
public class ContinentService {

    private final ContinentRepository continentRepository;

    public ContinentService(ContinentRepository continentRepository) {
        this.continentRepository = continentRepository;
    }

    public Optional<ContinentResponse> findById(String code) {
        return continentRepository.findById(code).map(this::toResponse);
    }

    public List<ContinentResponse> findAll() {
        return continentRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    private ContinentResponse toResponse(Continent continent) {
        return new ContinentResponse(
                continent.getCode(),
                continent.getName()
        );
    }
}
