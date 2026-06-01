package org.heinrich10.dto.responses;

import io.micronaut.serde.annotation.Serdeable;

import java.sql.Timestamp;

@Serdeable
public record PersonResponse(
        Long id,
        String firstName,
        String lastName,
        String countryCode,
        Timestamp createdAt,
        Timestamp updatedAt
) {
}
