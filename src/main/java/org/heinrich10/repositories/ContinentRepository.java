package org.heinrich10.repositories;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import org.heinrich10.models.Continent;

@JdbcRepository(dialect = Dialect.H2)
public interface ContinentRepository extends CrudRepository<Continent, String> {
}
