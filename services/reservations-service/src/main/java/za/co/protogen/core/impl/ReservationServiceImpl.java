/**
 *
 * @author luyas
 */

/*this is the implementation of the ReservationService interface which overrides methods in the interface */
package za.co.protogen.core.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.time.LocalDate;
import za.co.protogen.core.ReservationService;
import za.co.protogen.persistence.models.ReservationEntity;
import za.co.protogen.persistence.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import za.co.protogen.adapter.ReservationMappers;
import za.co.protogen.controller.models.ReservationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ReservationServiceImpl implements ReservationService {
    private static final Logger logger = LoggerFactory.getLogger(ReservationServiceImpl.class);

    private final RestTemplate restTemplate;
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(RestTemplate restTemplate, ReservationRepository reservationRepository) {
        this.restTemplate = restTemplate;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void addReservation(ReservationDTO reservationDTO) {
        boolean user = true;
        boolean car = true;
        ReservationEntity reservation = ReservationMappers.INSTANCE.populateResrvationEntity(reservationDTO);
        // Verify car existence
        ResponseEntity<Object> carResponse = restTemplate
                .getForEntity("http://localhost:9102/cars/" + reservation.getCarId(), Object.class);

        if (carResponse.getStatusCode() != HttpStatus.OK || carResponse.getBody() == null) {
            // car not found
            car = false;
            logger.warn("Car not found for ID: {}", reservation.getCarId());
        }

        // Verify user existence
        ResponseEntity<Object> userResponse = restTemplate
                .getForEntity("http://localhost:9101/users/" + reservation.getUserId(), Object.class);

        if (userResponse.getStatusCode() != HttpStatus.OK || userResponse.getBody() == null) {
            // User not found
            user = false;
            logger.warn("User not found for ID: {}", reservation.getUserId());
        }
        if (user != false && car != false) {

            reservationRepository.save(reservation);
            logger.info("Reservation added successfully.");

        } else {
            logger.error("Failed to add reservation. User or car not found.");
        }
        ;

    }

    @Override
    public void removeReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);
        logger.info("Successfully removed Resvation:  {}", reservationId);
    }

    @Override
    public ReservationEntity getReservationById(Long reservationId) {
        Optional<ReservationEntity> optionalReservation = reservationRepository.findById(reservationId);
        logger.info("Reservation found: {}", optionalReservation);
        return optionalReservation.orElse(null);

    }

    @Override
    public List<ReservationEntity> getAllReservations() {
        logger.info("Retriving all resrvations");
        return reservationRepository.findAll();
    }

    @Override
    public void updateReservation(Long reservationId, ReservationEntity updatedReservation) {
        Optional<ReservationEntity> optionalExistingReservation = reservationRepository.findById(reservationId);
        optionalExistingReservation.ifPresent(existingReservation -> {

            if (updatedReservation.getCarId() != null) {
                // CHANGING CAR
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
            logger.info("Reservation updated: {}", reservationId);
        });
    }

    @Override
    public List<ReservationEntity> searchReservations(Long userId, Long carId, LocalDate fromDate, LocalDate toDate) {
        List<ReservationEntity> reservatiionsList = reservationRepository.findAll();
        return reservatiionsList.stream()
                .filter(r -> (userId < 0 || r.getUserId().equals(userId)) &&
                        (carId < 0 || r.getCarId().equals(carId)) &&
                        (fromDate == null || r.getFromDate().isEqual(fromDate) ||
                                r.getFromDate().isAfter(fromDate))
                        &&
                        (toDate == null || r.getToDate().isEqual(toDate) ||
                                r.getToDate().isBefore(toDate)))
                .collect(Collectors.toList());
    }

}
