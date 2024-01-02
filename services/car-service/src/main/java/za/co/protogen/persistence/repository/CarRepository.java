package za.co.protogen.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.protogen.domain.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findByMakeIgnoreCase(String make);

    List<Car> findByYear(int year);

    List<Car> findByColorIgnoreCase(String color);

}
