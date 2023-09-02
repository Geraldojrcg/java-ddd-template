package com.example.javadddtemplate.data.user.contracts;

import com.example.javadddtemplate.domain.user.entities.User;

public interface CreateUserRepositoryInterface {
    void execute(User user);
}
