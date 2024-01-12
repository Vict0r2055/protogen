package za.co.protogen.adapter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import za.co.protogen.persistence.models.ReservationEntity;
import za.co.protogen.controller.models.ReservationDTO;

@Mapper
public interface ReservationMappers {
    ReservationMappers INSTANCE = Mappers.getMapper(ReservationMappers.class);

    ReservationEntity populateResrvationEntity(ReservationDTO reservationDTO);
}
