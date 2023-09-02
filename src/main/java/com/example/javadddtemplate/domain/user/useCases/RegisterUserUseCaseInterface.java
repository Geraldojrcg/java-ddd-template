package com.example.javadddtemplate.domain.user.useCases;

import com.example.javadddtemplate.domain.user.entities.User;
import com.example.javadddtemplate.domain.core.exceptions.ValidationException;

public interface RegisterUserUseCaseInterface {
    void execute(User user) throws ValidationException;
}
