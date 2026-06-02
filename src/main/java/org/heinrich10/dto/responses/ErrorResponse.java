package org.heinrich10.dto.responses;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record ErrorResponse(
        int status,
        String error,
        String message
) {
}
