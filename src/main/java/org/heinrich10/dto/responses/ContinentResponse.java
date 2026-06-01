package org.heinrich10.dto.responses;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record ContinentResponse(
        String code,
        String name
) {
}
