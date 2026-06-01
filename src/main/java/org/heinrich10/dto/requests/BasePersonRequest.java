package org.heinrich10.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BasePersonRequest {
    @NotNull
    @NotBlank
    private String firstName;
    private String lastName;
    @NotNull
    @NotBlank
    private String countryCode;

    public BasePersonRequest() {
    }

    public BasePersonRequest(String firstName, String lastName, String countryCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.countryCode = countryCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
