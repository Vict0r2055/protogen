package za.co.protogen.domain.models;

/**
 *
 * @author luyas
 */

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class CarDomain {

   @Id
   private int carId;
   private String transmission;
   private String make;
   private String model;
   @Column(name = "manufacturingYear")
   private int year;
   private String color;
   private String engine;
   private String fuelType;
   private int mileage;
   private String vin;
   private double price;
   private int ownerId;
   private List<String> features;

   public CarDomain() {
   }

   // getter methods

   public int getCarId() {
      return this.carId;
   }

   public String getColor() {
      return this.color;
   }

   public int getOwnerId() {
      return this.ownerId;
   }

   public String getMake() {
      return this.make;
   }

   public String getModel() {
      return this.model;
   }

   public int getYear() {
      return this.year;
   }

   public int getMileage() {
      return this.mileage;
   }

   public double getPrice() {
      return this.price;
   }

   public String getTransmission() {
      return this.transmission;
   }

   public String getEngine() {
      return this.engine;
   }

   public String getFuelType() {
      return this.fuelType;
   }

   // Setter methods

   public void setCarId(int var1) {
      this.carId = var1;
   }

   public void setTransmission(String var1) {
      this.transmission = var1;
   }

   public void setFuelType(String var1) {
      this.fuelType = var1;
   }

   public void setMake(String var1) {
      this.make = var1;
   }

   public void setModel(String var1) {
      this.model = var1;
   }

   public void setYear(int var1) {
      this.year = var1;
   }

   public void setColor(String var1) {
      this.color = var1;
   }

   public void setEngine(String var1) {
      this.engine = var1;
   }

   public void setMileage(int var1) {
      this.mileage = var1;
   }

   public void setVin(String var1) {
      this.vin = var1;
   }

   public void setPrice(double var1) {
      this.price = var1;
   }

   public void setOwnerId(int var1) {
      this.ownerId = var1;
   }

   public void setFeatures(List<String> var1) {
      this.features = var1;
   }

   public List<String> getFeatures() {
      return this.features;
   }

   // i made this to override the toString method to return more understandable
   // code easy to read when running the application main method
   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("\n");
      sb.append("Car ID: ").append(carId).append("\n");
      sb.append("Make: ").append(make).append("\n");
      sb.append("Model: ").append(model).append("\n");
      sb.append("Year: ").append(year).append("\n");
      sb.append("Color: ").append(color).append("\n");
      sb.append("Transmission: ").append(transmission).append("\n");
      sb.append("Engine: ").append(engine).append("\n");
      sb.append("Fuel Type: ").append(fuelType).append("\n");
      sb.append("Mileage: ").append(mileage).append("\n");
      sb.append("VIN: ").append(vin).append("\n");
      sb.append("Price: ").append(price).append("\n");
      sb.append("Owner ID: ").append(ownerId).append("\n");
      sb.append("Features: ").append(features).append("\n");

      return sb.toString();
   }

}
