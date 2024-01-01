/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.protogen.core;

// imports
import java.util.List;
import java.time.LocalDate;
import za.co.protogen.domain.Reservation;

// interface for reservation object
public interface ReservationService {
    void addReservation(Reservation reservation);
    void removeReservation(Long reservationId);
    Reservation getReservationById(Long reservationId);
    List<Reservation> getAllReservations();
    void updateReservation(Long reservationId, Reservation updatedReservation);
    List<Reservation> searchReservations(Long userId, Long carId, LocalDate fromDate, LocalDate toDate);

    
}
