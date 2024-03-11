package org.heinrich10.models;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotNull;

@Serdeable
@MappedEntity("persons")
public class Person {

    @Id
    @GeneratedValue(GeneratedValue.Type.AUTO)
    private Long id;
    @NotNull
    private String firstName;
    private String lastName;
    @NotNull
    private String countryCode;

    public Person(Long id, String firstName, String countryCode) {
        this.id = id;
        this.firstName = firstName;
        this.countryCode = countryCode;
    }
    public Person(Long id, String firstName, String lastName, String countryCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.countryCode = countryCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
