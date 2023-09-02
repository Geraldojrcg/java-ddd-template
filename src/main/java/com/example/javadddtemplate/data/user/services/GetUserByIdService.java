package com.example.javadddtemplate.data.user.services;

import com.example.javadddtemplate.data.user.contracts.GetUserByIdRepositoryInterface;
import com.example.javadddtemplate.domain.core.exceptions.ValidationException;
import com.example.javadddtemplate.domain.user.entities.User;
import com.example.javadddtemplate.domain.user.useCases.GetUserByIdUseCaseInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GetUserByIdService implements GetUserByIdUseCaseInterface {
    private final GetUserByIdRepositoryInterface repository;

    @Autowired
    public GetUserByIdService(GetUserByIdRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public Optional<User> execute(UUID id) throws ValidationException {
        return repository.execute(id);
    }
}
