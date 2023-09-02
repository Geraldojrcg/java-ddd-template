package com.example.javadddtemplate.data.user.contracts;

import com.example.javadddtemplate.domain.core.exceptions.ValidationException;
import com.example.javadddtemplate.domain.user.entities.User;

import java.util.Optional;

public interface GetUserByEmailRepositoryInterface {
    Optional<User> execute(String email) throws ValidationException;
}
