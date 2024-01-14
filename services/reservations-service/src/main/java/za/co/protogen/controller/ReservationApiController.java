package za.co.protogen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.protogen.core.ReservationService;
import za.co.protogen.persistence.models.ReservationEntity;
import za.co.protogen.controller.models.ReservationDTO;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationApiController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationApiController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public ResponseEntity<List<ReservationEntity>> getAllReservations() {
        List<ReservationEntity> reservations = reservationService.getAllReservations();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping("/{reservationId}")
    public ResponseEntity<ReservationEntity> getReservationById(@PathVariable("reservationId") Long reservationId) {
        ReservationEntity reservation = reservationService.getReservationById(reservationId);
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addReservation(@RequestBody ReservationDTO reservation) {
        reservationService.addReservation(reservation);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{reservationId}")
    public ResponseEntity<Void> updateReservation(@PathVariable("reservationId") Long reservationId,
            @RequestBody ReservationEntity updatedReservation) {
        reservationService.updateReservation(reservationId, updatedReservation);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<Void> removeReservation(@PathVariable("reservationId") Long reservationId) {
        reservationService.removeReservation(reservationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
