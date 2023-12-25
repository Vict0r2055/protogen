package za.co.protogen;

import za.co.protogen.core.UserService;
import za.co.protogen.core.impl.UserServiceImpl;
import za.co.protogen.domain.User;
import za.co.protogen.utility.Constant;

import java.time.LocalDate;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        // Displaying initial users
        System.out.println("Initial Users:");
        for (User user : Constant.users) {
            System.out.println(user);
        }

        // Retrieving all users
        List<User> allUsers = userService.getAllUsers();
        System.out.println("\nAll Users:");
        for (User user : allUsers) {
            System.out.println(user);
        }

        // Retrieving a user by ID
        User retrievedUser = userService.getUserById(2L);
        System.out.println("\nRetrieved User by ID: " + retrievedUser);

        // Updating a user
        userService.updateUser(2L, "UpdatedFirstName", "UpdatedLastName", LocalDate.of(1995, 3, 10), "555555555555");

        System.out.println("\nUser Updated:");
        System.out.println(userService.getUserById(2L));



        // Searching for users
        List<User> searchResults = userService.searchUsers("John", null, null, null);
        System.out.println("\nSearch Results:");
        for (User result : searchResults) {
            System.out.println(result);
        }

        // Removing a user
        userService.removeUser(1L);

        // Displaying updated user list from Constant class
        System.out.println("\nUpdated Users after removal:");
        for (User user : Constant.users) {
            System.out.println(user);
        }
    }
}
