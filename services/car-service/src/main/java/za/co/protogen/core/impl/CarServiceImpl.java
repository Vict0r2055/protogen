/**
 *
 * @author luyas
 */

/*this is the implementation of the CarService interface which overrides methods in the interface */
package za.co.protogen.core.impl;

import za.co.protogen.core.CarService;
import za.co.protogen.domain.Car;
import java.util.ArrayList;
import java.util.List;
import za.co.protogen.utility.Constant;

// import org.apache.tomcat.util.bcel.classfile.Constant;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {
    private List<Car> cars = Constant.cars;

    // public CarServiceImpl() {
    // this.cars = new ArrayList<>();
    // }

    // // constructor
    // public CarServiceImpl(List<Car> cars) {
    // this.cars = cars;
    // }

    // override methods
    @Override
    public void addCar(Car car) {
        Constant.cars.add(car);
    }

    @Override
    public void removeCar(int carId) {
        cars.removeIf(car -> Integer.toString(carId).equals(Integer.toString(car.getCarId())));
    }

    @Override
    public Car getCarById(int carId) {
        return cars.stream()
                .filter(car -> car.getCarId() == carId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Car> getAllCars() {
        return new ArrayList<>(Constant.cars);
    }

    @Override
    public List<Car> getCarsByMake(String make) {
        List<Car> carsByMake = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMake().equalsIgnoreCase(make)) {
                carsByMake.add(car);
            }
        }
        return carsByMake;
    }

    @Override
    public List<Car> getCarsByYear(int year) {
        List<Car> carsByYear = new ArrayList<>();
        for (Car car : cars) {
            if (car.getYear() == year) {
                carsByYear.add(car);
            }
        }
        return carsByYear;
    }

    @Override
    public List<Car> getCarsByColor(String color) {
        List<Car> carsByColor = new ArrayList<>();
        for (Car car : cars) {
            if (car.getColor().equalsIgnoreCase(color)) {
                carsByColor.add(car);
            }
        }
        return carsByColor;
    }

    @Override
    public void updateCar(int carId, Car updatedCar) {
        for (int i = 0; i < cars.size(); i++) {
            Car existingCar = cars.get(i);
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
                // if (updatedCar.getVin() != null && !updatedCar.getVin().isEmpty()) {
                // existingCar.setVin(updatedCar.getVin());
                // }
                if (updatedCar.getOwnerId() > 0) {
                    existingCar.setOwnerId(updatedCar.getOwnerId());
                }
                // if (updatedCar.getFeatures() != null) {
                // existingCar.setFeatures(updatedCar.getFeatures());
                // }

                break;
            }
        }
    }

    @Override
    public double calculateAverageMileage() {
        if (cars.isEmpty()) {
            return 0.0;
        }

        int totalMileage = cars.stream().mapToInt(Car::getMileage).sum();
        return (double) totalMileage / cars.size();
    }

    @Override
    public Car findCheapestCar() {
        return cars.stream().min(java.util.Comparator.comparingDouble(Car::getPrice)).orElse(null);
    }

    @Override
    public Car findMostExpensiveCar() {
        return cars.stream().max(java.util.Comparator.comparingDouble(Car::getPrice)).orElse(null);
    }

    @Override
    public Car findNewestCar() {
        return cars.stream().max(java.util.Comparator.comparingInt(Car::getYear)).orElse(null);
    }

    @Override
    public Car findOldestCar() {
        return cars.stream().min(java.util.Comparator.comparingInt(Car::getYear)).orElse(null);
    }

    @Override
    public List<Car> searchCars(String make, String model, double minPrice, double maxPrice) {
        List<Car> searchResults = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMake().equalsIgnoreCase(make) &&
                    car.getModel().equalsIgnoreCase(model) &&
                    car.getPrice() >= minPrice &&
                    car.getPrice() <= maxPrice) {
                searchResults.add(car);
            }
        }
        return searchResults;
    }

}
