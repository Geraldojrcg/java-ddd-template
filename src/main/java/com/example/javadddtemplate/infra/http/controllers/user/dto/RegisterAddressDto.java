package com.example.javadddtemplate.infra.http.controllers.user.dto;

import com.example.javadddtemplate.domain.core.exceptions.ValidationException;
import com.example.javadddtemplate.domain.user.valueObjects.Address;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

public class RegisterAddressDto {
    @NotNull
    private String city;

    @NotNull
    private String neighborhood;

    @NotNull
    private String street;

    @Nullable
    private Integer number;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Nullable
    public Integer getNumber() {
        return number;
    }

    public void setNumber(@Nullable Integer number) {
        this.number = number;
    }

    public Address toEntity() throws ValidationException {
        Address address = new Address();
        address.setCity(this.getCity());
        address.setNeighborhood(this.getNeighborhood());
        address.setStreet(this.getStreet());

        if(this.getNumber() != null){
            address.setNumber(this.getNumber());
        }

        return address;
    }
}
