package za.co.protogen.adapter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import za.co.protogen.persistence.models.CarEntity;
import za.co.protogen.controller.models.CarDTO;

@Mapper
public interface CarMappers {
    CarMappers INSTANCE = Mappers.getMapper(CarMappers.class);

    CarEntity populateCarEntity(CarDTO carDTO);
}
