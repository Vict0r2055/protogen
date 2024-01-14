package za.co.protogen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.protogen.core.CarService;
import za.co.protogen.persistence.models.CarEntity;
import za.co.protogen.controller.models.CarDTO;

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
    public ResponseEntity<List<CarEntity>> getAllCars() {
        List<CarEntity> cars = carService.getAllCars();
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/{carId}")
    public ResponseEntity<CarEntity> getCarById(@PathVariable("carId") Long carId) {
        CarEntity car = carService.getCarById(carId);
        return car != null ? ResponseEntity.ok(car) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<String> addCar(@RequestBody CarDTO car) {
        try {
            carService.addCar(car);
            return ResponseEntity.ok("Car added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error adding car");
        }
    }

    @DeleteMapping("/{carId}")
    public ResponseEntity<String> removeCar(@PathVariable("carId") Long carId) {
        try {
            carService.removeCar(carId);
            return ResponseEntity.ok("Car removed successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error removing car");
        }
    }

    @PutMapping("/{carId}")
    public ResponseEntity<String> updateCar(@PathVariable("carId") Long carId, @RequestBody CarEntity updatedCar) {
        try {
            carService.updateCar(carId, updatedCar);
            return ResponseEntity.ok("Car updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error updating car");
        }
    }
}
