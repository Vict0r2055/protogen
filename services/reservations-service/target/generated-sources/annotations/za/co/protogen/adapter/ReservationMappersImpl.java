package za.co.protogen.adapter;

import javax.annotation.processing.Generated;
import za.co.protogen.controller.models.ReservationDTO;
import za.co.protogen.persistence.models.ReservationEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-12T20:04:22+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
public class ReservationMappersImpl implements ReservationMappers {

    @Override
    public ReservationEntity populateResrvationEntity(ReservationDTO reservationDTO) {
        if ( reservationDTO == null ) {
            return null;
        }

        ReservationEntity reservationEntity = new ReservationEntity();

        reservationEntity.setId( reservationDTO.getId() );
        reservationEntity.setUserId( reservationDTO.getUserId() );
        reservationEntity.setCarId( reservationDTO.getCarId() );
        reservationEntity.setFromDate( reservationDTO.getFromDate() );
        reservationEntity.setToDate( reservationDTO.getToDate() );
        reservationEntity.setPickUpLocation( reservationDTO.getPickUpLocation() );
        reservationEntity.setDropoffLocation( reservationDTO.getDropoffLocation() );

        return reservationEntity;
    }
}
