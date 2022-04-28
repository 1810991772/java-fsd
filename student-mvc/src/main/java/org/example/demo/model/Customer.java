package org.example.demo.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {

    @NotNull(message = "first name can not be null")
    @Size(min = 4, message = "first name length must be at-least 4 char long")
    private String firstName;
    @NotNull(message = "last name can not be null")
    @Size(min = 1, message = "last name length must be at-least 1 char long")
    private String lastName;

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
}
