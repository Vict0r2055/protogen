package za.co.protogen.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.protogen.persistence.models.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
