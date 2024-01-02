package za.co.protogen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.protogen.core.CarService;
import za.co.protogen.domain.Car;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarApiController {

    private final CarService carService;

    @Autowired
    public CarApiController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{carId}")
    public Car getCarById(@PathVariable("carId") int carId) {
        return carService.getCarById(carId);
    }

    @PostMapping
    public void addCar(@RequestBody Car car) {
        System.out.println("Received Car JSON: " + car.toString());
        carService.addCar(car);
    }

    @DeleteMapping("/{carId}")
    public void removeCar(@PathVariable("carId") int carId) {
        carService.removeCar(carId);
    }

    @PutMapping("/{carId}")
    public void updateCar(@PathVariable("carId") int carId, @RequestBody Car updatedCar) {
        carService.updateCar(carId, updatedCar);
    }

}
