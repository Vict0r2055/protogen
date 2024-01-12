package com.baeldung.openapi.api;

import com.baeldung.openapi.model.Car;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * A delegate to be called by the {@link CarsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-12T19:47:08.187410200+02:00[Africa/Johannesburg]")
public interface CarsApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /cars : Add a new car
     *
     * @param car  (required)
     * @return Car added successfully (status code 200)
     *         or Bad request. Check the request body for valid data. (status code 500)
     * @see CarsApi#addCar
     */
    default ResponseEntity<Void> addCar(Car car) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /cars : Get a list of cars
     *
     * @return Successful response (status code 200)
     * @see CarsApi#getAllCars
     */
    default ResponseEntity<Void> getAllCars() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /cars/{carId} : Get car details by ID
     *
     * @param carId ID of the car (required)
     * @return Successful response (status code 200)
     * @see CarsApi#getCarById
     */
    default ResponseEntity<Void> getCarById(Integer carId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /cars/{carId} : Delete car by ID
     *
     * @param carId ID of the car (required)
     * @return Car deleted successfully (status code 200)
     *         or Car not found (status code 404)
     * @see CarsApi#removeCar
     */
    default ResponseEntity<Void> removeCar(Integer carId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /cars/{carId} : Update a car by ID
     *
     * @param carId ID of the car to update (required)
     * @param car  (required)
     * @return Car updated successfully (status code 200)
     *         or Bad request. Check the request body for valid data. (status code 500)
     * @see CarsApi#updateCar
     */
    default ResponseEntity<Void> updateCar(Integer carId,
        Car car) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
