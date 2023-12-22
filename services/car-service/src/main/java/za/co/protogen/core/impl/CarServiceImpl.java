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

public class CarServiceImpl implements CarService {
    private List<Car> cars;

    // constructor
    public CarServiceImpl(List<Car> cars) {
        this.cars = cars;
    }

    // override methods
    @Override
    public void addCar(Car car) {
        cars.add(car);
    }

    @Override
    public void removeCar(int carId) {
        cars.removeIf(car -> Integer.toString(carId).equals(Integer.toString(car.getOwnerId())));
    }

    @Override
    public Car getCarById(int carId) {
        return cars.stream()
                .filter(car -> car.getOwnerId() == carId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Car> getAllCars() {
        return new ArrayList<>(cars);
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
            if (cars.get(i).getOwnerId() == carId) {
                cars.set(i, updatedCar);
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
