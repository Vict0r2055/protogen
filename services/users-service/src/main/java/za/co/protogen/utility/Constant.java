package za.co.protogen.utility;

import za.co.protogen.domain.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Constant {
    public static final String USERS_RESOURCE = "/users";
    public static List<User> users = new ArrayList<>();
    
    static {
        User user1 = new User();
        user1.setId(1L);
        user1.setFirstName("John");
        user1.setLastName("Doe");
        user1.setDateOfBirth(LocalDate.of(1990, 1, 1));
        user1.setRsaId("1234567890123");
        users.add(user1);
        
        User user2 = new User();
        user2.setId(2L);
        user2.setFirstName("Jane");
        user2.setLastName("Smith");
        user2.setDateOfBirth(LocalDate.of(1985, 6, 15));
        user2.setRsaId("9876543210987");
        users.add(user2);

        // testing parameterized constructor for User object
        User user3 = new User(3L, "Luyanda", "Mpanza", LocalDate.of(2000, 10, 13), "0010135344082");
        users.add(user3);

    }
}
