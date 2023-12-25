/**
 *
 * @author luyas
 */

/*this is the implementation of the ReservationService interface which overrides methods in the interface */
package za.co.protogen.core.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;
import za.co.protogen.core.ReservationService;
import za.co.protogen.domain.Reservation;
import za.co.protogen.utility.Constant;


public class ReservationServiceImpl implements ReservationService {
    @Override
    public void addReservation(Reservation reservation) {
        Constant.reservations.add(reservation);
    }

    @Override
    public void removeReservation(Long reservationId) {
        Constant.reservations.removeIf(r -> r.getId().equals(reservationId));
    }

    @Override
    public Reservation getReservationById(Long reservationId) {
        return Constant.reservations.stream()
                .filter(r -> r.getId().equals(reservationId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return Constant.reservations;
    }

    @Override
    public boolean updateReservation(Reservation reservation) {
        int index = Constant.reservations.indexOf(reservation);
        if (index != -1) {
            Constant.reservations.set(index, reservation);
            return true;  // Update successful reservation was found
        } else {
            return false; // Reservation not found
        }
    }


    @Override
    public List<Reservation> searchReservations(Long userId, Long carId, LocalDate fromDate, LocalDate toDate) {
       
        return Constant.reservations.stream()
                .filter(r ->
                        (userId == null || r.getUserId().equals(userId)) &&
                        (carId == null || r.getCarId().equals(carId)) &&
                        (fromDate == null || r.getFromDate().isEqual(fromDate) || r.getFromDate().isAfter(fromDate)) &&
                        (toDate == null || r.getToDate().isEqual(toDate) || r.getToDate().isBefore(toDate))
                )
                .collect(Collectors.toList());
    }
    
}
