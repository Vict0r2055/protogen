package za.co.protogen.persistence.models;

import java.util.List;
import jakarta.persistence.*;
import jakarta.persistence.ElementCollection;
// import za.co.protogen.persistence.models.CarFeature;
import lombok.*;

@Entity
@Table(name = "cars")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;

    @Column(name = "transmission")
    private String transmission;

    private String make;
    private String model;

    @Column(name = "manufacturingYear")
    private int year;

    private String color;
    private String engine;
    @Column(name = "fuelType")
    private String fuelType;
    private int mileage;
    private String vin;
    private double price;

    @Column(name = "ownerId")
    private int ownerId;

    @Column(name = "features")
    @ElementCollection
    private List<String> features;

}
