package com.example.javadddtemplate.infra.http.controllers.user.dto;

import com.example.javadddtemplate.domain.user.entities.User;
import com.example.javadddtemplate.domain.user.valueObjects.Address;

import java.util.UUID;

public class UserDto {
    private UUID id;
    private String email;
    private String name;
    private Address address;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static UserDto fromEntity(User entity) {
        UserDto user = new UserDto();
        user.setId(entity.getId());
        user.setName(entity.getName());
        user.setEmail(entity.getEmail());
        user.setAddress(entity.getAddress());

        return user;
    }
}
