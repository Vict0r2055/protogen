/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.protogen.core;
import za.co.protogen.domain.Car;
import java.util.List;

/**
 *
 * @author luyas
 */

public interface CarService {
    void addCar(Car car);
    void removeCar(int carId);
    Car getCarById(int carId);
    List<Car> getAllCars();
    List<Car> getCarsByMake(String make);
    List<Car> getCarsByYear(int year);
    List<Car> getCarsByColor(String color);
    void updateCar(int carId, Car updatedCar);
    double calculateAverageMileage();
    Car findCheapestCar();
    Car findMostExpensiveCar();
    Car findNewestCar();
    Car findOldestCar();
    List<Car> searchCars(String make, String model, double minPrice, double maxPrice);
    
}
