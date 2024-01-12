package za.co.protogen.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.protogen.persistence.models.CarEntity;
// import za.co.protogen.domain.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {

    List<CarEntity> findByMakeIgnoreCase(String make);

    List<CarEntity> findByYear(int year);

    List<CarEntity> findByColorIgnoreCase(String color);

}
