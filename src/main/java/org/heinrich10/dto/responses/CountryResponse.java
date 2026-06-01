package org.heinrich10.dto.responses;

import io.micronaut.serde.annotation.Serdeable;

import java.sql.Timestamp;

@Serdeable
public record CountryResponse(
        String code,
        String name,
        Integer phone,
        String symbol,
        String capital,
        String currency,
        String continentCode,
        String alpha3,
        Timestamp createdAt,
        Timestamp updatedAt
) {
}
