package org.heinrich10.requests;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class UpdatePersonRequest extends BasePersonRequest {
    public UpdatePersonRequest(String firstName, String lastName, String countryCode) {
        super(firstName, lastName, countryCode);
    }
}
