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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final RestTemplate restTemplate;

    @Autowired
    public ReservationServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void addReservation(Reservation reservation) {
        boolean user = true;
        boolean car = true;

        // Verify car existence
        ResponseEntity<Object> carResponse = restTemplate
                .getForEntity("http://localhost:9102/cars/" + reservation.getCarId(), Object.class);

        if (carResponse.getStatusCode() != HttpStatus.OK || carResponse.getBody() == null) {
            // car not found
            car = false;
            System.out.println("car not found");
        }

        // Verify user existence
        ResponseEntity<Object> userResponse = restTemplate
                .getForEntity("http://localhost:9101/users/" + reservation.getUserId(), Object.class);

        if (userResponse.getStatusCode() != HttpStatus.OK || userResponse.getBody() == null) {
            // User not found
            user = false;
            System.out.println("user not found");
        }
        if (user != false && car != false) {
            Constant.reservations.add(reservation);

        }
        ;

    }

    @Override
    public void removeReservation(Long reservationId) {
        Constant.reservations.removeIf(r -> {
            Long id = r.getId();
            return id != null && id.equals(reservationId);
        });
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
    public void updateReservation(Long reservationId, Reservation updatedReservation) {
        Reservation existingReservation = getReservationById(reservationId);
        if (existingReservation != null) {
            // Update the existing reservation with the fields of the updated reservation
            existingReservation.setUserId(updatedReservation.getUserId());
            existingReservation.setCarId(updatedReservation.getCarId());
            existingReservation.setFromDate(updatedReservation.getFromDate());
            existingReservation.setToDate(updatedReservation.getToDate());
            existingReservation.setPickUpLocation(updatedReservation.getPickUpLocation());
            existingReservation.setDropoffLocation(updatedReservation.getDropoffLocation());
        }

    }

    @Override
    public List<Reservation> searchReservations(Long userId, Long carId, LocalDate fromDate, LocalDate toDate) {

        return Constant.reservations.stream()
                .filter(r -> (userId == null || r.getUserId().equals(userId)) &&
                        (carId == null || r.getCarId().equals(carId)) &&
                        (fromDate == null || r.getFromDate().isEqual(fromDate) || r.getFromDate().isAfter(fromDate)) &&
                        (toDate == null || r.getToDate().isEqual(toDate) || r.getToDate().isBefore(toDate)))
                .collect(Collectors.toList());
    }

}
