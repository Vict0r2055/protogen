package za.co.protogen.core;

import java.util.List;
// import java.time.LocalDate;
import za.co.protogen.domain.User;

public interface UserService {
    // interface's methodds
    void addUser(User user);

    void removeUser(int Id);

    User getUserById(int Id);

    List<User> getAllUsers();

    void updateUser(int Id, User updatedUser);

    // List<User> searchUsers(String firstName, String lastName, LocalDate
    // dateOfBirth, String rsaId);
}