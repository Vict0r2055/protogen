package za.co.protogen.adapter;

import javax.annotation.processing.Generated;
import za.co.protogen.controller.models.UserDTO;
import za.co.protogen.persistence.models.UserEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-14T10:26:12+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
public class UserMappersImpl implements UserMappers {

    @Override
    public UserEntity populateResrvationEntity(UserDTO reservationDTO) {
        if ( reservationDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( (long) reservationDTO.getId() );
        userEntity.setFirstName( reservationDTO.getFirstName() );
        userEntity.setLastName( reservationDTO.getLastName() );
        userEntity.setDateOfBirth( reservationDTO.getDateOfBirth() );
        userEntity.setRsaId( reservationDTO.getRsaId() );

        return userEntity;
    }
}
