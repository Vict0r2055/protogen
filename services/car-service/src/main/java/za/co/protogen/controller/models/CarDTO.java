package za.co.protogen.controller.models;

import java.util.List;
import lombok.*;

// import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CarDTO {
    private Long carId;
    private String transmission;
    private String make;
    private String model;
    private int year;
    private String color;
    private String engine;
    private String fuelType;
    private int mileage;
    private String vin;
    private double price;
    private int ownerId;
    private List<String> features;

}