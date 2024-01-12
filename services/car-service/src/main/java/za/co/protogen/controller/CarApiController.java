package za.co.protogen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.protogen.core.CarService;
import za.co.protogen.domain.models.CarDomain;
import za.co.protogen.persistence.models.CarEntity;
import java.util.List;
import za.co.protogen.controller.models.CarDTO;

@RestController
@RequestMapping("/cars")
public class CarApiController {

    private final CarService carService;

    @Autowired
    public CarApiController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<CarEntity> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{carId}")
    public CarEntity getCarById(@PathVariable("carId") Long carId) {
        return carService.getCarById(carId);
    }

    @PostMapping
    public void addCar(@RequestBody CarDTO car) {
        System.out.println("Received Car JSON: " + car.toString());
        carService.addCar(car);
    }

    @DeleteMapping("/{carId}")
    public void removeCar(@PathVariable("carId") Long carId) {
        carService.removeCar(carId);
    }

    @PutMapping("/{carId}")
    public void updateCar(@PathVariable("carId") Long carId, @RequestBody CarEntity updatedCar) {
        carService.updateCar(carId, updatedCar);
    }

}