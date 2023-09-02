package com.example.javadddtemplate.domain.user.useCases;

import com.example.javadddtemplate.domain.core.exceptions.ValidationException;
import com.example.javadddtemplate.domain.user.entities.User;

import java.util.Optional;
import java.util.UUID;

public interface GetUserByIdUseCaseInterface {
    Optional<User> execute(UUID id) throws ValidationException;
}
