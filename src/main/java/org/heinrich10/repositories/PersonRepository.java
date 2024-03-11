package org.heinrich10.repositories;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.PageableRepository;
import org.heinrich10.models.Person;
import org.heinrich10.requests.CreatePersonRequest;
import org.heinrich10.requests.UpdatePersonRequest;

import java.util.Optional;

@JdbcRepository(dialect = Dialect.H2)
public interface PersonRepository extends PageableRepository<Person, Long>{}
