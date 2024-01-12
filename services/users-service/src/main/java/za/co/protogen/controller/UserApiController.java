package za.co.protogen.controller;

import org.springframework.web.bind.annotation.*;
// import za.co.protogen.domain.User;
import za.co.protogen.persistence.models.UserEntity;
import za.co.protogen.core.UserService;
import java.util.List;
import za.co.protogen.controller.models.UserDTO;

@RestController
@RequestMapping("/users")
public class UserApiController {

    private final UserService userService;

    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{Id}")
    public UserEntity getUserById(@PathVariable("Id") Long Id) {
        return userService.getUserById(Id);
    }

    @PostMapping
    public void addUser(@RequestBody UserDTO user) {
        userService.addUser(user);
    }

    @PutMapping("/{Id}")
    public void updateUser(@PathVariable("Id") Long Id, @RequestBody UserEntity user) {
        userService.updateUser(Id, user);
    }

    @DeleteMapping("/{Id}")
    public void removeUser(@PathVariable("Id") Long Id) {
        userService.removeUser(Id);
    }

}