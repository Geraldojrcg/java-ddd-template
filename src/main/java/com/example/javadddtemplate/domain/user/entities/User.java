package com.example.javadddtemplate.domain.user.entities;

import com.example.javadddtemplate.domain.core.exceptions.ValidationException;
import com.example.javadddtemplate.domain.core.validators.EmailValidator;
import com.example.javadddtemplate.domain.user.valueObjects.Address;

import java.util.UUID;

public class User {
    private UUID id;
    private String email;
    private String name;
    private String password;
    private Address address;

    public User() {
        this.id = UUID.randomUUID();
    }

    public User(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws ValidationException {
        if(!EmailValidator.validate(email)) {
            throw new ValidationException(email, "is invalid");
        }
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws ValidationException {
        if(name.length() > 20) {
            throw new ValidationException(name, "should be less than 20 characters");
        }
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return getId().equals(user.getId());
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", address=" + address +
                '}';
    }
}
