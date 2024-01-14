package com.baeldung.openapi.api;

import com.baeldung.openapi.model.Reservation;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * A delegate to be called by the {@link ReservationsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-14T10:59:25.375654100+02:00[Africa/Johannesburg]")
public interface ReservationsApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /reservations : Add a new reservation
     *
     * @param reservation  (required)
     * @return Reservation added successfully (status code 201)
     *         or Bad request (status code 400)
     * @see ReservationsApi#addReservation
     */
    default ResponseEntity<Void> addReservation(Reservation reservation) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /reservations : Get a list of reservations
     *
     * @return Successful response (status code 200)
     * @see ReservationsApi#getAllReservations
     */
    default ResponseEntity<Void> getAllReservations() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /reservations/{reservationId} : Get reservation details by ID
     *
     * @param reservationId ID of the reservation (required)
     * @return Successful response (status code 200)
     * @see ReservationsApi#getReservationById
     */
    default ResponseEntity<Void> getReservationById(Integer reservationId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /reservations/{reservationId} : Delete reservation by ID
     *
     * @param reservationId ID of the reservation (required)
     * @return Reservation deleted successfully (status code 204)
     *         or Reservation not found (status code 404)
     * @see ReservationsApi#removeReservation
     */
    default ResponseEntity<Void> removeReservation(Integer reservationId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /reservations/{reservationId} : Update reservation details by ID
     *
     * @param reservationId ID of the reservation (required)
     * @param reservation  (required)
     * @return Reservation updated successfully (status code 200)
     *         or Bad request (status code 400)
     * @see ReservationsApi#updateReservation
     */
    default ResponseEntity<Void> updateReservation(Integer reservationId,
        Reservation reservation) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
