package za.co.protogen.adapter;

import javax.annotation.processing.Generated;
import za.co.protogen.controller.models.UserDTO;
import za.co.protogen.persistence.models.UserEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-12T20:35:07+0200",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.37.0.v20240103-0614, environment: Java 17.0.9 (Eclipse Adoptium)"
)
public class UserMappersImpl implements UserMappers {

    @Override
    public UserEntity populateResrvationEntity(UserDTO reservationDTO) {
        if ( reservationDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setDateOfBirth( reservationDTO.getDateOfBirth() );
        userEntity.setFirstName( reservationDTO.getFirstName() );
        userEntity.setId( (long) reservationDTO.getId() );
        userEntity.setLastName( reservationDTO.getLastName() );
        userEntity.setRsaId( reservationDTO.getRsaId() );

        return userEntity;
    }
}
