package com.example.javadddtemplate.data.user.contracts;

import com.example.javadddtemplate.domain.user.entities.User;

import java.util.List;

public interface GetAllUsersRepositoryInterface {
    List<User> execute();
}
