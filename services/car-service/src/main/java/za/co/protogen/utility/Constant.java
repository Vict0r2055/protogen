package za.co.protogen.utility;

import java.util.ArrayList;
import java.util.List;
import za.co.protogen.domain.Car;

public class Constant {
    public static List<Car> cars = new ArrayList<>();
    static {
        // mock data
        Car car1 = new Car();
        car1.setCarId(1);
        car1.setMake("Toyota");
        car1.setModel("Corolla");
        car1.setYear(2021);
        car1.setColor("White");
        car1.setEngine("1.8L");
        car1.setTransmission("Automatic");
        car1.setFuelType("Gasoline");
        car1.setMileage(10000);
        car1.setVin("ABC123");
        car1.setPrice(25000);
        car1.setOwnerId(123);
        car1.setFeatures(new ArrayList<>());
        cars.add(car1);

        Car car2 = new Car();
        car2.setCarId(2);
        car2.setMake("Honda");
        car2.setModel("Civic");
        car2.setYear(2020);
        car2.setColor("Red");
        car2.setEngine("1.5L");
        car2.setTransmission("CVT");
        car2.setFuelType("Gasoline");
        car2.setMileage(15000);
        car2.setVin("XYZ789");
        car2.setPrice(22000);
        car2.setOwnerId(456);
        car2.setFeatures(new ArrayList<>());
        cars.add(car2);

        Car car3 = new Car();
        car3.setCarId(3);
        car3.setMake("Honda");
        car3.setModel("Civic");
        car3.setYear(2023);
        car3.setColor("blue");
        car3.setEngine("1.5L");
        car3.setTransmission("CVT");
        car3.setFuelType("Gasoline");
        car3.setMileage(15000);
        car3.setVin("XYZ987");
        car3.setPrice(22000);
        car3.setOwnerId(496);
        car3.setFeatures(new ArrayList<>());
        cars.add(car3);

        // Add more cars as needed
    }
}