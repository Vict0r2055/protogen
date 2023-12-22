/**
 *
 * @author luyas
 */
package za.co.protogen;

import za.co.protogen.domain.Car; // imports Car class 
import za.co.protogen.core.CarService; // imports CarServices interface
import za.co.protogen.core.impl.CarServiceImpl;// imports the implementation logic for CarServices
import za.co.protogen.utility.Constant; // contains mock data

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // Initialize the car data using the Constant class
        List<Car> cars = Constant.cars;

        // Creating an instance of the CarService with the list
        CarService carService = new CarServiceImpl(cars);

        // Getting All cars in list
        List<Car> allCars = carService.getAllCars();
        System.out.println("All Cars:");
        allCars.forEach(System.out::println);

        // Filtering cars by make
        List<Car> toyotaCars = carService.getCarsByMake("Toyota");
        System.out.println("\nToyota Cars:");
        toyotaCars.forEach(System.out::println);

    }
}
