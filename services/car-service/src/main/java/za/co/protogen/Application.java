/**
 *
 * @author luyas
 */
package za.co.protogen;

import za.co.protogen.domain.Car;
import za.co.protogen.core.CarService;
import za.co.protogen.core.impl.CarServiceImpl;
import za.co.protogen.utility.Constant;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // Initialize the car data using the Constant class
        List<Car> cars = Constant.cars;

        // Create an instance of the CarService with the initialized car data
        CarService carService = new CarServiceImpl(cars);

        // Retrieving all cars
        List<Car> allCars = carService.getAllCars();
        System.out.println("All Cars:");
        allCars.forEach(System.out::println);

        // Retrieving cars by make
        List<Car> toyotaCars = carService.getCarsByMake("Toyota");
        System.out.println("\nToyota Cars:");
        toyotaCars.forEach(System.out::println);

        // Other operations can be performed similarly
    }
}
