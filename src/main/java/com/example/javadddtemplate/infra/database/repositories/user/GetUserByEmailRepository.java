package com.example.javadddtemplate.infra.database.repositories.user;

import com.example.javadddtemplate.data.user.contracts.GetUserByEmailRepositoryInterface;
import com.example.javadddtemplate.domain.core.exceptions.ValidationException;
import com.example.javadddtemplate.domain.user.entities.User;
import com.example.javadddtemplate.infra.database.mappers.UserModelMapper;
import com.example.javadddtemplate.infra.database.models.UserJpaModel;
import com.example.javadddtemplate.infra.database.repositories.user.jpa.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetUserByEmailRepository implements GetUserByEmailRepositoryInterface {
    private final JpaUserRepository repository;

    @Autowired
    public GetUserByEmailRepository(JpaUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<User> execute(String email) throws ValidationException {

        Optional<UserJpaModel> userJpaModelOptional = repository.findByEmail(email);

        if(userJpaModelOptional.isEmpty()) {
            return Optional.empty();
        }

        UserJpaModel userJpaModel = userJpaModelOptional.get();

        return Optional.of(UserModelMapper.toEntity(userJpaModel));
    }
}
