package za.co.protogen.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable("Id") Long Id) {
        UserEntity user = userService.getUserById(Id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addUser(@RequestBody UserDTO user) {
        userService.addUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<Void> updateUser(@PathVariable("Id") Long Id, @RequestBody UserEntity user) {
        userService.updateUser(Id, user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<Void> removeUser(@PathVariable("Id") Long Id) {
        userService.removeUser(Id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
