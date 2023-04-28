package com.example.usermanagemennt.controler;


import com.example.usermanagemennt.entities.User;
import com.example.usermanagemennt.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("users/{email}")
    public User getUser(@PathVariable String email) {
        System.out.println("GOT EMAIL REQUEST");
        User user = new User();
        user.setName("Nameeeeee");
//        return userRepository.getUserByEmail(email);
        return user;
    }
}
