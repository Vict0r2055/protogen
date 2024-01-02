/**
 *
 * @author luyas
 */

/*
 * this is the implementation of the CarService interface which overrides
 * methods in the interface
 */
package za.co.protogen.core.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.protogen.core.CarService;
import za.co.protogen.domain.Car;
import za.co.protogen.persistence.repository.CarRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void addCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public void removeCar(int carId) {
        carRepository.deleteById(carId);
    }

    @Override
    public Car getCarById(int carId) {
        Optional<Car> optionalCar = carRepository.findById(carId);
        return optionalCar.orElse(null);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> getCarsByMake(String make) {
        return carRepository.findByMakeIgnoreCase(make);
    }

    @Override
    public List<Car> getCarsByYear(int year) {
        return carRepository.findByYear(year);
    }

    @Override
    public List<Car> getCarsByColor(String color) {
        return carRepository.findByColorIgnoreCase(color);
    }

    @Override
    public void updateCar(int carId, Car updatedCar) {
        Optional<Car> optionalExistingCar = carRepository.findById(carId);
        optionalExistingCar.ifPresent(existingCar -> {
            if (existingCar.getCarId() == carId) {
                if (updatedCar.getTransmission() != null && !updatedCar.getTransmission().isEmpty()) {
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

            }
            carRepository.save(existingCar);
        });
    }

}
