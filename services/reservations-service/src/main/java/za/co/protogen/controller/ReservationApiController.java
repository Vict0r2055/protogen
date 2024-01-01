package za.co.protogen.controller;

import org.springframework.web.bind.annotation.*;
import za.co.protogen.domain.Reservation;
import za.co.protogen.core.ReservationService;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationApiController {

    private final ReservationService reservationService;

    public ReservationApiController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{reservationId}")
    public Reservation getReservationById(@PathVariable("reservationId") Long reservationId) {
        return reservationService.getReservationById(reservationId);
    }

    @PostMapping
    public void addReservation(@RequestBody Reservation reservation) {
        reservationService.addReservation(reservation);
    }

    @PutMapping("/{reservationId}")
    public void updateReservation(@PathVariable("reservationId") Long reservationId,
            @RequestBody Reservation updatedReservation) {
        reservationService.updateReservation(reservationId, updatedReservation);
    }

    @DeleteMapping("/{reservationId}")
    public void removeReservation(@PathVariable("reservationId") Long reservationId) {
        reservationService.removeReservation(reservationId);
    }
}
