package za.co.protogen.adapter;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import za.co.protogen.controller.models.CarDTO;
import za.co.protogen.persistence.models.CarEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-12T19:24:17+0200",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.37.0.v20240103-0614, environment: Java 17.0.9 (Eclipse Adoptium)"
)
public class CarMappersImpl implements CarMappers {

    @Override
    public CarEntity populateCarEntity(CarDTO carDTO) {
        if ( carDTO == null ) {
            return null;
        }

        CarEntity carEntity = new CarEntity();

        carEntity.setCarId( carDTO.getCarId() );
        carEntity.setColor( carDTO.getColor() );
        carEntity.setEngine( carDTO.getEngine() );
        List<String> list = carDTO.getFeatures();
        if ( list != null ) {
            carEntity.setFeatures( new ArrayList<String>( list ) );
        }
        carEntity.setFuelType( carDTO.getFuelType() );
        carEntity.setMake( carDTO.getMake() );
        carEntity.setMileage( carDTO.getMileage() );
        carEntity.setModel( carDTO.getModel() );
        carEntity.setOwnerId( carDTO.getOwnerId() );
        carEntity.setPrice( carDTO.getPrice() );
        carEntity.setTransmission( carDTO.getTransmission() );
        carEntity.setVin( carDTO.getVin() );
        carEntity.setYear( carDTO.getYear() );

        return carEntity;
    }
}
