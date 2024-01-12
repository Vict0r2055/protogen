/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.protogen.core;

// import za.co.protogen.domain.Car;
import java.util.List;
import za.co.protogen.persistence.models.CarEntity;

/**
 *
 * @author luyas
 */

// defined an interface to ease creation of an object

public interface CarService {
    void addCar(CarEntity car);

    void removeCar(Long carId);

    CarEntity getCarById(Long carId);

    List<CarEntity> getAllCars();

    List<CarEntity> getCarsByMake(String make);

    List<CarEntity> getCarsByYear(int year);

    List<CarEntity> getCarsByColor(String color);

    void updateCar(Long carId, CarEntity updatedCar);

}