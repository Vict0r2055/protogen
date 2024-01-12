/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.protogen.core;

// imports
import java.util.List;
import java.time.LocalDate;
import za.co.protogen.persistence.models.ReservationEntity;

// interface for reservation object
public interface ReservationService {
    void addReservation(ReservationEntity reservation);

    void removeReservation(Long reservationId);

    ReservationEntity getReservationById(Long reservationId);

    List<ReservationEntity> getAllReservations();

    void updateReservation(Long reservationId, ReservationEntity updatedReservation);

    List<ReservationEntity> searchReservations(Long userId, Long carId, LocalDate fromDate, LocalDate toDate);

}
