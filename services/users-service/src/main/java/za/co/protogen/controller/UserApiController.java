package za.co.protogen.controller;

import org.springframework.web.bind.annotation.*;
import za.co.protogen.domain.User;
import za.co.protogen.core.UserService;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserApiController {

    private final UserService userService;

    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable("userId") Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping("/{userId}")
    public void updateUser(@PathVariable("userId") Long userId, @RequestBody User user) {
        userService.updateUser(userId, user);
    }

    @DeleteMapping("/{userId}")
    public void removeUser(@PathVariable("userId") Long userId) {
        userService.removeUser(userId);
    }

}