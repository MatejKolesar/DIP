/**
 * This controller defines the interface that is used for user interaction

 *
 * @author  Matej Kolesar
 * @version 1.0
 * @since   13-05-2023
 */
package com.example.usermanagement.controler;


import com.example.usermanagement.entities.User;
import com.example.usermanagement.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // GET a single user by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable UUID id) {
        return userService.getUserById(id);
    }

    // POST create a new user
    @PostMapping("")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // PUT update an existing user
    @PutMapping("/{id}")
    public User updateUser(@PathVariable UUID id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    // DELETE delete an existing user
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
    }

    @PutMapping("{filesId}/share/{userId}")
    public void shareFile(@PathVariable String filesId, @PathVariable UUID userId) {
        userService.shareFileWithUser(filesId, userId);
    }

    @PostMapping("/share/{userId}")
    public void createFile( @PathVariable UUID userId, @RequestBody Map<String, String> info) {
        userService.addFileToUser( userId, info);
    }
}
