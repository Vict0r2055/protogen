package za.co.protogen.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.protogen.domain.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
