package com.example.javadddtemplate.domain.user.valueObjects;

import com.example.javadddtemplate.domain.core.exceptions.ValidationException;

import java.util.Optional;

public class Address {
    private String city;
    private String neighborhood;
    private String street;
    private Optional<Integer> number = Optional.empty();

    public String getCity() {
        return city;
    }

    public void setCity(String city) throws ValidationException {
        if(city.length() > 20) {
            throw new ValidationException(city, "should be less than 20 characters");
        }
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) throws ValidationException {
        if(city.length() > 20) {
            throw new ValidationException(city, "should be less than 30 characters");
        }
        this.neighborhood = neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) throws ValidationException {
        if(city.length() > 40) {
            throw new ValidationException(city, "should be less than 40 characters");
        }
        this.street = street;
    }

    public Optional<Integer> getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = Optional.of(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (getNumber() != address.getNumber()) return false;
        if (!getCity().equals(address.getCity())) return false;
        if (!getNeighborhood().equals(address.getNeighborhood())) return false;
        return getStreet().equals(address.getStreet());
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", street='" + street + '\'' +
                ", number=" + number +
                '}';
    }
}
