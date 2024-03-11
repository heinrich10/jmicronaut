package org.heinrich10.repositories;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.PageableRepository;
import org.heinrich10.models.Country;

@JdbcRepository(dialect = Dialect.H2)
public interface CountryRepository extends PageableRepository<Country, String> {}
