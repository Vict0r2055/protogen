package za.co.protogen.adapter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import za.co.protogen.persistence.models.UserEntity;
import za.co.protogen.controller.models.UserDTO;

@Mapper
public interface UserMappers {
    UserMappers INSTANCE = Mappers.getMapper(UserMappers.class);

    UserEntity populateResrvationEntity(UserDTO reservationDTO);
}
