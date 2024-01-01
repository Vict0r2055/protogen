package za.co.protogen.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.protogen.domain.Car;
import za.co.protogen.core.CarService;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarApiController {

    private final CarService carService;

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
        carService.addCar(car);
    }

    @PutMapping("/{carId}")
    public ResponseEntity<Void> updateCar(@PathVariable("carId") int carId, @RequestBody Car updatedCar) {
        carService.updateCar(carId, updatedCar);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{carId}")
    public void removeCar(@PathVariable("carId") int carId) {
        carService.removeCar(carId);
    }
}
