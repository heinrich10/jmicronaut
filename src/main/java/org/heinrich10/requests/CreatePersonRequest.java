package org.heinrich10.requests;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class CreatePersonRequest extends BasePersonRequest{
    public CreatePersonRequest() {
    }

    public CreatePersonRequest(String firstName, String lastName, String countryCode) {
        super(firstName, lastName, countryCode);
    }
}
