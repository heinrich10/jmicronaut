package org.heinrich10.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.heinrich10.models.Person;

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

    public Person toPerson() {
        return new Person(null, firstName, lastName, countryCode);
    }

    public Person toPerson(Long id) {
        return new Person(id, firstName, lastName, countryCode);
    }
}

