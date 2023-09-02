package com.example.javadddtemplate.infra.database.mappers;

import com.example.javadddtemplate.domain.core.exceptions.ValidationException;
import com.example.javadddtemplate.domain.user.entities.User;
import com.example.javadddtemplate.domain.user.valueObjects.Address;
import com.example.javadddtemplate.infra.database.models.AddressJpaModel;
import com.example.javadddtemplate.infra.database.models.UserJpaModel;

public class UserModelMapper {
    public static User toEntity(UserJpaModel model) throws ValidationException {
        User user = new User(model.getId());
        user.setName(model.getName());
        user.setEmail(model.getEmail());
        user.setPassword(model.getPassword());

        Address address = new Address();
        address.setCity(model.getAddress().getCity());
        address.setNeighborhood(model.getAddress().getNeighborhood());
        address.setStreet(model.getAddress().getStreet());
        address.setNumber(model.getAddress().getNumber());

        user.setAddress(address);

        return user;
    }

    public static UserJpaModel toModel(User entity) {
        UserJpaModel model = new UserJpaModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setEmail(entity.getEmail());
        model.setPassword(entity.getPassword());

        AddressJpaModel addressModel = new AddressJpaModel();
        addressModel.setCity(entity.getAddress().getCity());
        addressModel.setNeighborhood(entity.getAddress().getNeighborhood());
        addressModel.setStreet(entity.getAddress().getStreet());

        if(entity.getAddress().getNumber().isPresent()){
            addressModel.setNumber(entity.getAddress().getNumber().get());
        }

        model.setAddress(addressModel);

        return model;
    }
}
