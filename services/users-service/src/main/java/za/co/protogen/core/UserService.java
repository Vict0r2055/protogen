package za.co.protogen.core;

import java.util.List;
import java.time.LocalDate;
import za.co.protogen.domain.User;

public interface UserService {
    // interface's methodds 
    void addUser(User user);
    void removeUser(Long userId);
    User getUserById(Long userId);
    List<User> getAllUsers();
    void updateUser(Long userId, String firstName, String lastName, LocalDate dateOfBirth, String rsaId);
    List<User> searchUsers(String firstName, String lastName, LocalDate dateOfBirth, String rsaId);
}