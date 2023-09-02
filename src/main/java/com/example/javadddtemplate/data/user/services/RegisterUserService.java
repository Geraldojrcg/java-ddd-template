package com.example.javadddtemplate.data.user.services;

import com.example.javadddtemplate.data.user.contracts.CreateUserRepositoryInterface;
import com.example.javadddtemplate.domain.core.exceptions.ValidationException;
import com.example.javadddtemplate.domain.user.entities.User;
import com.example.javadddtemplate.domain.user.useCases.RegisterUserUseCaseInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService implements RegisterUserUseCaseInterface {
    private final CreateUserRepositoryInterface repository;

    @Autowired
    public RegisterUserService(CreateUserRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public void execute(User user) throws ValidationException {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        user.setPassword(encryptedPassword);

        repository.execute(user);
    }
}
