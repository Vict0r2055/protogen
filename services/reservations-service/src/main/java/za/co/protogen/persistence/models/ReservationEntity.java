/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author luyas
 */
package za.co.protogen.persistence.models;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reservations")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservationId")
    private Long id;
    @Column(name = "userId")
    private Long userId;
    @Column(name = "carId")
    private Long carId;
    @Column(name = "pickup")
    private LocalDate fromDate;
    @Column(name = "dropOff")
    private LocalDate toDate;
    @Column(name = "pickupLocation")
    private String pickUpLocation;
    @Column(name = "dropOffLocation")
    private String dropoffLocation;

}
