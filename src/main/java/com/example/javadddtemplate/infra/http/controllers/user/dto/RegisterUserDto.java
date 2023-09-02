package com.example.javadddtemplate.infra.http.controllers.user.dto;

import com.example.javadddtemplate.domain.core.exceptions.ValidationException;
import com.example.javadddtemplate.domain.user.entities.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class RegisterUserDto {
    @Email
    private String email;

    @NotNull
    private String name;

    @NotNull
    private String password;

    @NotNull
    private RegisterAddressDto address;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RegisterAddressDto getAddress() {
        return address;
    }

    public void setAddress(RegisterAddressDto address) {
        this.address = address;
    }

    public User toEntity() throws ValidationException {
        User user = new User();
        user.setName(this.getName());
        user.setEmail(this.getEmail());
        user.setPassword(this.getPassword());

        user.setAddress(this.getAddress().toEntity());

        return user;
    }
}
