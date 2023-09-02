
package com.example.javadddtemplate.infra.database.repositories.user;

import com.example.javadddtemplate.data.user.contracts.GetUserByIdRepositoryInterface;
import com.example.javadddtemplate.domain.core.exceptions.ValidationException;
import com.example.javadddtemplate.domain.user.entities.User;
import com.example.javadddtemplate.infra.database.mappers.UserModelMapper;
import com.example.javadddtemplate.infra.database.models.UserJpaModel;
import com.example.javadddtemplate.infra.database.repositories.user.jpa.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GetUserByIdRepository implements GetUserByIdRepositoryInterface {
    private final JpaUserRepository repository;

    @Autowired
    public GetUserByIdRepository(JpaUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<User> execute(UUID id) throws ValidationException {

        Optional<UserJpaModel> userJpaModelOptional = repository.findById(id);

        if(userJpaModelOptional.isEmpty()) {
            return Optional.empty();
        }

        UserJpaModel userJpaModel = userJpaModelOptional.get();

        return Optional.of(UserModelMapper.toEntity(userJpaModel));
    }
}
