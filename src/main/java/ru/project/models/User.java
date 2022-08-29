package ru.project.models;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class User {
    private int id;
    @NotEmpty(message = "the field cannot be empty")
    private String name;

    @NotEmpty(message = "the field cannot be empty")
    private String surname;

    @NotEmpty(message = "the field cannot be empty")
    @Email(message = "Email should be valid")
    private String email;

    @NotEmpty(message = "the field cannot be empty")
    private String address;

    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
