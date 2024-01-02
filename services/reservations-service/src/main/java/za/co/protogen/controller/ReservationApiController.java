package za.co.protogen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.protogen.domain.Reservation;
import za.co.protogen.core.ReservationService;

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
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{reservationId}")
    public Reservation getReservationById(@PathVariable("reservationId") int reservationId) {
        return reservationService.getReservationById(reservationId);
    }

    @PostMapping
    public void addReservation(@RequestBody Reservation reservation) {
        reservationService.addReservation(reservation);
    }

    @PutMapping("/{reservationId}")
    public void updateReservation(@PathVariable("reservationId") int reservationId,
            @RequestBody Reservation updatedReservation) {
        reservationService.updateReservation(reservationId, updatedReservation);
    }

    @DeleteMapping("/{reservationId}")
    public void removeReservation(@PathVariable("reservationId") int reservationId) {
        reservationService.removeReservation(reservationId);
    }
}
