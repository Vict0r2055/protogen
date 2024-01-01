package za.co.protogen.core.impl;

// imports
import za.co.protogen.core.UserService;
import za.co.protogen.domain.User;
import za.co.protogen.utility.Constant;
// import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    // implements addUser method from UserService interface
    @Override
    public void addUser(User user) {
        Constant.users.add(user);
    }

    // implenments removeUser method from UserService interface
    @Override
    public void removeUser(Long userId) {
        Iterator<User> iterator = Constant.users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId().equals(userId)) {
                iterator.remove();
                break;
            }
        }
    }

    // implements getUserById method from UserService interface
    @Override
    public User getUserById(Long userId) {
        for (User user : Constant.users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    // implements getAllUsers method from UserService interface
    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(Constant.users);
    }

    // implements updateUser method from UserService interface
    @Override
    public void updateUser(Long userId, User updatedUser) {
        for (int i = 0; i < Constant.users.size(); i++) {
            User user = Constant.users.get(i);
            if (user.getId().equals(userId)) {
                // Update only the provided attributes
                if (updatedUser.getFirstName() != null)
                    user.setFirstName(updatedUser.getFirstName());
                if (updatedUser.getLastName() != null)
                    user.setLastName(updatedUser.getLastName());
                if (updatedUser.getDateOfBirth() != null)
                    user.setDateOfBirth(updatedUser.getDateOfBirth());
                if (updatedUser.getRsaId() != null)
                    user.setRsaId(updatedUser.getRsaId());

                Constant.users.set(i, user);
                break;
            }
        }
    }

    // // implements searchUsers method from UserService interface
    // @Override
    // public List<User> searchUsers(String firstName, String lastName, LocalDate
    // dateOfBirth, String rsaId) {
    // List<User> searchResults = new ArrayList<>();
    // for (User user : Constant.users) {
    // if ((firstName == null || firstName.equalsIgnoreCase(user.getFirstName())) &&
    // (lastName == null || lastName.equalsIgnoreCase(user.getLastName())) &&
    // (dateOfBirth == null || dateOfBirth.equals(user.getDateOfBirth())) &&
    // (rsaId == null || rsaId.equals(user.getRsaId()))) {
    // searchResults.add(user);
    // }
    // }
    // return searchResults;
    // }
}
