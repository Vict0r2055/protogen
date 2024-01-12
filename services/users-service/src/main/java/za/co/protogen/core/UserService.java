package za.co.protogen.core;

import java.util.List;
import java.time.LocalDate;
// import za.co.protogen.domain.User;
import za.co.protogen.persistence.models.UserEntity;

public interface UserService {
    // interface's methodds
    void addUser(UserEntity user);

    void removeUser(Long Id);

    UserEntity getUserById(Long Id);

    List<UserEntity> getAllUsers();

    void updateUser(Long Id, UserEntity updatedUser);

    List<UserEntity> searchUsers(String firstName, String lastName, LocalDate dateOfBirth, String rsaId);
}