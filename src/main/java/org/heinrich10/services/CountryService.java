package org.heinrich10.services;

import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.heinrich10.models.Country;
import org.heinrich10.repositories.CountryRepository;
import org.heinrich10.dto.responses.CountryResponse;

import java.util.Optional;

@Singleton
public class CountryService {

    private final CountryRepository countryRepository;

    @Inject
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Optional<CountryResponse> findById(String code) {
        return countryRepository.findById(code).map(this::toResponse);
    }

    public Page<CountryResponse> findAll(Pageable pageable) {
        return countryRepository.findAll(pageable).map(this::toResponse);
    }

    private CountryResponse toResponse(Country country) {
        return new CountryResponse(
                country.getCode(),
                country.getName(),
                country.getPhone(),
                country.getSymbol(),
                country.getCapital(),
                country.getCurrency(),
                country.getContinentCode(),
                country.getAlpha3(),
                country.getCreatedAt(),
                country.getUpdatedAt()
        );
    }
}
