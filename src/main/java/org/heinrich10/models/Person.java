package org.heinrich10.models;

import io.micronaut.data.annotation.*;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;

@Serdeable
@MappedEntity
public class Person {

    @Id
    @GeneratedValue(GeneratedValue.Type.AUTO)
    private Long id;
    @NotNull
    private String firstName;
    private String lastName;
    @NotNull
    private String countryCode;
    @DateUpdated
    private Timestamp updatedAt;
    @DateCreated
    private Timestamp createdAt;

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

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
