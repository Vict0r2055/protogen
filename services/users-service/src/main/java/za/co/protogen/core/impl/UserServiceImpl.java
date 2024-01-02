package za.co.protogen.core.impl;

// imports
import za.co.protogen.core.UserService;
import za.co.protogen.domain.User;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import za.co.protogen.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // implements addUser method from UserService interface
    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    // implenments removeUser method from UserService interface
    @Override
    public void removeUser(int Id) {
        userRepository.deleteById(Id);
    }

    // implements getUserById method from UserService interface
    @Override
    public User getUserById(int Id) {
        Optional<User> optionalUser = userRepository.findById(Id);
        return optionalUser.orElse(null);

    }

    // implements getAllUsers method from UserService interface
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(int Id, User updatedUser) {
        Optional<User> optionalExistingUser = userRepository.findById(Id);
        optionalExistingUser.ifPresent(existingUser -> {
            if (existingUser.getId() == Id) {
                // Update only the provided attributes
                if (updatedUser.getFirstName() != null)
                    existingUser.setFirstName(updatedUser.getFirstName());
                if (updatedUser.getLastName() != null)
                    existingUser.setLastName(updatedUser.getLastName());
                if (updatedUser.getDateOfBirth() != null)
                    existingUser.setDateOfBirth(updatedUser.getDateOfBirth());
                if (updatedUser.getRsaId() != null)
                    existingUser.setRsaId(updatedUser.getRsaId());

            }
            userRepository.save(existingUser);
        });
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
