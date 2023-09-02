package com.example.javadddtemplate.infra.database.repositories.user.jpa;

import com.example.javadddtemplate.infra.database.models.UserJpaModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface JpaUserRepository extends CrudRepository<UserJpaModel, UUID> {
    @Override
    List<UserJpaModel> findAll();
    Optional<UserJpaModel> findByEmail(String email);
}
