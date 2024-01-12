package za.co.protogen.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<ReservationEntity> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{reservationId}")
    public ReservationEntity getReservationById(@PathVariable("reservationId") Long reservationId) {
        return reservationService.getReservationById(reservationId);
    }

    @PostMapping
    public void addReservation(@RequestBody ReservationDTO reservation) {
        reservationService.addReservation(reservation);
    }

    @PutMapping("/{reservationId}")
    public void updateReservation(@PathVariable("reservationId") Long reservationId,
            @RequestBody ReservationEntity updatedReservation) {
        reservationService.updateReservation(reservationId, updatedReservation);
    }

    @DeleteMapping("/{reservationId}")
    public void removeReservation(@PathVariable("reservationId") Long reservationId) {
        reservationService.removeReservation(reservationId);
    }
}
