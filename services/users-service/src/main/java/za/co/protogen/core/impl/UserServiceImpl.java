package za.co.protogen.core.impl;

// imports
import za.co.protogen.core.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import za.co.protogen.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import za.co.protogen.persistence.models.UserEntity;
import java.time.LocalDate;
import za.co.protogen.adapter.UserMappers;
import za.co.protogen.controller.models.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // implements addUser method from UserService interface
    @Override
    public void addUser(UserDTO userDTO) {
        UserEntity user = UserMappers.INSTANCE.populateResrvationEntity(userDTO);
        userRepository.save(user);
        logger.info("New user added: {}", user);
    }

    // implenments removeUser method from UserService interface
    @Override
    public void removeUser(Long Id) {
        userRepository.deleteById(Id);
        logger.info("User removed with id={}", Id);
    }

    // implements getUserById method from UserService interface
    @Override
    public UserEntity getUserById(Long Id) {
        Optional<UserEntity> optionalUser = userRepository.findById(Id);
        // logger.info("User not found for: {}",Id);
        return optionalUser.orElse(null);

    }

    // implements getAllUsers method from UserService interface
    @Override
    public List<UserEntity> getAllUsers() {
        logger.info("Retriving all users");
        return userRepository.findAll();
    }

    @Override
    public void updateUser(Long Id, UserEntity updatedUser) {
        Optional<UserEntity> optionalExistingUser = userRepository.findById(Id);
        optionalExistingUser.ifPresent(existingUser -> {
            if (existingUser.getId() == Id) {
                if (updatedUser.getFirstName() != null && !updatedUser.getFirstName().isEmpty()) {
                    existingUser.setFirstName(updatedUser.getFirstName());
                }
                if (updatedUser.getLastName() != null && !updatedUser.getLastName().isEmpty()) {
                    existingUser.setLastName(updatedUser.getLastName());
                }
                if (updatedUser.getDateOfBirth() != null) {
                    existingUser.setDateOfBirth(updatedUser.getDateOfBirth());
                }
                if (updatedUser.getRsaId() != null && !updatedUser.getRsaId().isEmpty()) {
                    existingUser.setRsaId(updatedUser.getRsaId());

                }
            }

            userRepository.save(existingUser);
            logger.info("User with ID: {} updated", Id);
        });
    }

    // implements searchUsers method from UserService interface
    // @Override
    // public List<UserEntity> searchUsers(String firstName, String lastName,
    // LocalDate dateOfBirth, String rsaId) {
    // List<UserEntity> usersList = userRepository.findAll();
    // List<UserEntity> searchResults = new ArrayList<>();

    // for (UserEntity userEntity : usersList) {
    // if ((firstName == null ||
    // firstName.equalsIgnoreCase(userEntity.getFirstName())) &&
    // (lastName == null || lastName.equalsIgnoreCase(userEntity.getLastName())) &&
    // (dateOfBirth == null || dateOfBirth.equals(userEntity.getDateOfBirth())) &&
    // (rsaId == null || rsaId.equals(userEntity.getRsaId()))) {
    // searchResults.add(userEntity);
    // }
    // }

    // return searchResults;
    // }
}
