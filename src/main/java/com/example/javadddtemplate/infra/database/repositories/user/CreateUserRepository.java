package com.example.javadddtemplate.infra.database.repositories.user;

import com.example.javadddtemplate.data.user.contracts.CreateUserRepositoryInterface;
import com.example.javadddtemplate.domain.user.entities.User;
import com.example.javadddtemplate.infra.database.mappers.UserModelMapper;
import com.example.javadddtemplate.infra.database.models.UserJpaModel;
import com.example.javadddtemplate.infra.database.repositories.user.jpa.JpaAddressRepository;
import com.example.javadddtemplate.infra.database.repositories.user.jpa.JpaUserRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateUserRepository implements CreateUserRepositoryInterface {
    private final JpaUserRepository userRepository;
    private final JpaAddressRepository addressRepository;

    public CreateUserRepository(JpaUserRepository userRepository, JpaAddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public void execute(User user) {
        UserJpaModel model = UserModelMapper.toModel(user);

        addressRepository.save(model.getAddress());
        userRepository.save(model);
    }
}
