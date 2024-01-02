/**
 *
 * @author luyas
 */

/*this is the implementation of the ReservationService interface which overrides methods in the interface */
package za.co.protogen.core.impl;

import java.util.List;
import java.util.Optional;
// import java.util.stream.Collectors;
// import java.time.LocalDate;
import za.co.protogen.core.ReservationService;
import za.co.protogen.domain.Reservation;
import za.co.protogen.persistence.repository.ReservationRepository;
// import za.co.protogen.utility.Constant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final RestTemplate restTemplate;
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(RestTemplate restTemplate, ReservationRepository reservationRepository) {
        this.restTemplate = restTemplate;
        this.reservationRepository = reservationRepository;
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
            reservationRepository.save(reservation);

        }
        ;

    }

    @Override
    public void removeReservation(int reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    @Override
    public Reservation getReservationById(int reservationId) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(reservationId);
        return optionalReservation.orElse(null);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public void updateReservation(int reservationId, Reservation updatedReservation) {
        Optional<Reservation> optionalExistingReservation = reservationRepository.findById(reservationId);
        optionalExistingReservation.ifPresent(existingReservation -> {
            if (updatedReservation.getUserId() != null) {
                existingReservation.setUserId(updatedReservation.getUserId());
            }
            if (updatedReservation.getCarId() != null) {
                existingReservation.setCarId(updatedReservation.getCarId());
            }
            if (updatedReservation.getFromDate() != null) {
                existingReservation.setFromDate(updatedReservation.getFromDate());
            }
            if (updatedReservation.getToDate() != null) {
                existingReservation.setToDate(updatedReservation.getToDate());
            }
            if (updatedReservation.getPickUpLocation() != null) {
                existingReservation.setPickUpLocation(updatedReservation.getPickUpLocation());
            }
            if (updatedReservation.getDropoffLocation() != null) {
                existingReservation.setDropoffLocation(updatedReservation.getDropoffLocation());
            }

            reservationRepository.save(existingReservation);
        });
    }

    // @Override
    // public List<Reservation> searchReservations(int userId, int carId, LocalDate
    // fromDate, LocalDate toDate) {

    // return Constant.reservations.stream()
    // .filter(r -> (userId == null || r.getUserId().equals(userId)) &&
    // (carId == null || r.getCarId().equals(carId)) &&
    // (fromDate == null || r.getFromDate().isEqual(fromDate) ||
    // r.getFromDate().isAfter(fromDate)) &&
    // (toDate == null || r.getToDate().isEqual(toDate) ||
    // r.getToDate().isBefore(toDate)))
    // .collect(Collectors.toList());
    // }

}
