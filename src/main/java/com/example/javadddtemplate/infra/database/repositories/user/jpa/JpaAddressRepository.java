package com.example.javadddtemplate.infra.database.repositories.user.jpa;

import com.example.javadddtemplate.infra.database.models.AddressJpaModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaAddressRepository extends CrudRepository<AddressJpaModel, UUID> {
}
