package com.example.usermanagement.services;

import com.example.usermanagement.entities.User;

import java.util.List;
import java.util.UUID;

public interface IUserService {

        List<User> getAllUsers();

        User getUserById(UUID id);

        User createUser(User user);

        User updateUser(UUID id, User user);

        void deleteUser(UUID id);


}
