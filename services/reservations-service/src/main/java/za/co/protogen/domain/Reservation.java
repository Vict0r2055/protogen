/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author luyas
 */
package za.co.protogen.domain;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    private Long id;
    private Long userId;
    private Long carId;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String pickUpLocation;
    private String dropoffLocation;

    // Constructors
    public Reservation() {
        // the default constructor
    }

    // parameterized constructor
    public Reservation(Long id, Long userId, Long carId, LocalDate fromDate, LocalDate toDate,
            String pickUpLocation, String dropoffLocation) {
        this.id = id;
        this.userId = userId;
        this.carId = carId;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.pickUpLocation = pickUpLocation;
        this.dropoffLocation = dropoffLocation;
    }

    // Getters and setters for Reservation object
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public String getDropoffLocation() {
        return dropoffLocation;
    }

    public void setDropoffLocation(String dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }

    // this overrides default tooString for object it returns well formatted result
    // easy to understand
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Reservation\n")
                .append("id=: ").append(id).append("\n")
                .append("userId: ").append(userId).append("\n")
                .append("carId: ").append(carId).append("\n")
                .append("fromDate: ").append(fromDate).append("\n")
                .append("toDate: ").append(toDate).append("\n")
                .append("pickUpLocation: '").append(pickUpLocation).append("'\n")
                .append("dropoffLocation: '").append(dropoffLocation).append("'\n");
        return sb.toString();
    }
}
