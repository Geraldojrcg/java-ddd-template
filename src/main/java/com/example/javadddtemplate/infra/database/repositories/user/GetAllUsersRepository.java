package com.example.javadddtemplate.infra.database.repositories.user;

import com.example.javadddtemplate.data.user.contracts.GetAllUsersRepositoryInterface;
import com.example.javadddtemplate.domain.core.exceptions.ValidationException;
import com.example.javadddtemplate.domain.user.entities.User;
import com.example.javadddtemplate.infra.database.mappers.UserModelMapper;
import com.example.javadddtemplate.infra.database.repositories.user.jpa.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllUsersRepository implements GetAllUsersRepositoryInterface {
    private final JpaUserRepository repository;

    @Autowired
    public GetAllUsersRepository(JpaUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> execute() {
        return repository.findAll().stream().map(model -> {
            try {
                return UserModelMapper.toEntity(model);
            } catch (ValidationException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
    }
}
