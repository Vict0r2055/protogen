/*
 * This is the implementation of the CarService interface which overrides
 * methods in the interface
 */
package za.co.protogen.core.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.protogen.core.CarService;
import za.co.protogen.domain.models.CarDomain;
import za.co.protogen.persistence.repository.CarRepository;
import za.co.protogen.persistence.models.CarEntity;
import za.co.protogen.adapter.CarMappers;
import za.co.protogen.controller.models.CarDTO;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service

public class CarServiceImpl implements CarService {
    private static final Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void addCar(CarDTO car) {
        CarEntity carE = CarMappers.INSTANCE.populateCarEntity(car);
        carRepository.save(carE);
        logger.info("Car added successfully");
    }

    @Override
    public void removeCar(Long carId) {
        carRepository.deleteById(carId);
        logger.info("Car removed successfully: {}", carId);
    }

    @Override
    public CarEntity getCarById(Long carId) {
        Optional<CarEntity> optionalCar = carRepository.findById(carId);
        return optionalCar.orElse(null);
    }

    @Override
    public List<CarEntity> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public List<CarEntity> getCarsByMake(String make) {
        return carRepository.findByMakeIgnoreCase(make);
    }

    @Override
    public List<CarEntity> getCarsByYear(int year) {
        return carRepository.findByYear(year);
    }

    @Override
    public List<CarEntity> getCarsByColor(String color) {
        return carRepository.findByColorIgnoreCase(color);
    }

    @Override
    public void updateCar(Long carId, CarEntity updatedCar) {
        Optional<CarEntity> optionalExistingCar = carRepository.findById(carId);
        optionalExistingCar.ifPresent(existingCar -> {
            if (existingCar.getCarId() == carId) {
                if (updatedCar.getTransmission() != null &&
                        !updatedCar.getTransmission().isEmpty()) {
                    existingCar.setTransmission(updatedCar.getTransmission());
                }
                if (updatedCar.getFuelType() != null && !updatedCar.getFuelType().isEmpty()) {
                    existingCar.setFuelType(updatedCar.getFuelType());
                }
                if (updatedCar.getColor() != null && !updatedCar.getColor().isEmpty()) {
                    existingCar.setColor(updatedCar.getColor());
                }
                if (updatedCar.getEngine() != null && !updatedCar.getEngine().isEmpty()) {
                    existingCar.setEngine(updatedCar.getEngine());
                }
                if (updatedCar.getMileage() >= 0) {
                    existingCar.setMileage(updatedCar.getMileage());
                }
                if (updatedCar.getPrice() >= 0) {
                    existingCar.setPrice(updatedCar.getPrice());
                }
                if (updatedCar.getMake() != null && !updatedCar.getMake().isEmpty()) {
                    existingCar.setMake(updatedCar.getMake());
                }
                if (updatedCar.getModel() != null && !updatedCar.getModel().isEmpty()) {
                    existingCar.setModel(updatedCar.getModel());
                }
                if (updatedCar.getYear() > 0) {
                    existingCar.setYear(updatedCar.getYear());
                }

                if (updatedCar.getOwnerId() > 0) {
                    existingCar.setOwnerId(updatedCar.getOwnerId());
                }
                if (updatedCar.getVin() != null && updatedCar.getVin().isEmpty()) {
                    existingCar.setVin(updatedCar.getVin());
                }

            }
            carRepository.save(existingCar);
            logger.info("Car with ID : {} updated successfully", carId);
        });
    }

}