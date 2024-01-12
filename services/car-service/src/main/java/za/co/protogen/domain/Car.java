/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.protogen.domain;

/**
 *
 * @author luyas
 */

import java.util.List;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class Car {
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
