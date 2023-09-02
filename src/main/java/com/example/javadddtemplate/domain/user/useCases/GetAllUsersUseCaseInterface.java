package com.example.javadddtemplate.domain.user.useCases;

import com.example.javadddtemplate.domain.user.entities.User;

import java.util.List;

public interface GetAllUsersUseCaseInterface {
    List<User> execute();
}
