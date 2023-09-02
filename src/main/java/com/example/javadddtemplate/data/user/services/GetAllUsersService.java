package com.example.javadddtemplate.data.user.services;

import com.example.javadddtemplate.data.user.contracts.GetAllUsersRepositoryInterface;
import com.example.javadddtemplate.domain.user.entities.User;
import com.example.javadddtemplate.domain.user.useCases.GetAllUsersUseCaseInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllUsersService implements GetAllUsersUseCaseInterface {
    private final GetAllUsersRepositoryInterface repository;

    @Autowired
    public GetAllUsersService(GetAllUsersRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public List<User> execute() {
        return repository.execute();
    }
}
