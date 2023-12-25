/**
 *
 * @author luyas
 */

package za.co.protogen;

import za.co.protogen.core.ReservationService;
import za.co.protogen.core.impl.ReservationServiceImpl;
import za.co.protogen.domain.Reservation;

import java.time.LocalDate;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // Initializing ReservationService
        ReservationService reservationService = new ReservationServiceImpl();

        // Adding a new reservation
        Reservation newReservation = new Reservation();
        newReservation.setId(3L);
        newReservation.setUserId(3L);
        newReservation.setCarId(3L);
        newReservation.setFromDate(LocalDate.of(2023, 7, 1));
        newReservation.setToDate(LocalDate.of(2023, 7, 5));
        newReservation.setPickUpLocation("Tokyo");
        newReservation.setDropoffLocation("Osaka");
        reservationService.addReservation(newReservation);

        // Print all reservations
        System.out.println("All Reservations:");
        List<Reservation> allReservations = reservationService.getAllReservations();
        for (Reservation reservation : allReservations) {
            System.out.println(reservation);
        }

        // Get reservation by ID
        Long reservationIdToFind = 1L;
        Reservation foundReservation = reservationService.getReservationById(reservationIdToFind);
        if (foundReservation != null) {
            System.out.println("\nReservation found by ID " + reservationIdToFind + ":");
            System.out.println(foundReservation);
        } else {
            System.out.println("\nReservation with ID " + reservationIdToFind + " not found.");
        }

        // Remove a reservation
        Long reservationIdToRemove = 2L;
        reservationService.removeReservation(reservationIdToRemove);
        System.out.println("\nRemoved reservation with ID " + reservationIdToRemove);

        // Printing updated reservations list
        System.out.println("\nUpdated Reservations:");
        allReservations = reservationService.getAllReservations();
        for (Reservation reservation : allReservations) {
            System.out.println(reservation);
        }

        // Updating a reservation
        Reservation reservationToUpdate = reservationService.getReservationById(3L);
        if (reservationToUpdate != null) {
            reservationToUpdate.setDropoffLocation("Kyoto");
            reservationService.updateReservation(reservationToUpdate);
            System.out.println("\nUpdated reservation with ID 3:");
            System.out.println(reservationToUpdate);
        } else {
            System.out.println("\nReservation with ID 3 not found.");
        }

        
    }
}
