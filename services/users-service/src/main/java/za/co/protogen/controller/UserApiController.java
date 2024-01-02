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

    @GetMapping("/{Id}")
    public User getUserById(@PathVariable("Id") int Id) {
        return userService.getUserById(Id);
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping("/{Id}")
    public void updateUser(@PathVariable("Id") int Id, @RequestBody User user) {
        userService.updateUser(Id, user);
    }

    @DeleteMapping("/{Id}")
    public void removeUser(@PathVariable("Id") int Id) {
        userService.removeUser(Id);
    }

}