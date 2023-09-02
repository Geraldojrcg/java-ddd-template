package com.example.javadddtemplate.infra.database.models;

import com.sun.istack.NotNull;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "User")
@Table(name = "users")
public class UserJpaModel {
    @Id
    @Type(type = "uuid-char")
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    private String name;

    @NotNull
    private String password;

    @NotNull
    @OneToOne()
    private AddressJpaModel address;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AddressJpaModel getAddress() {
        return address;
    }

    public void setAddress(AddressJpaModel address) {
        this.address = address;
    }
}
