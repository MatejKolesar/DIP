package com.example.usermanagement.repository;

import com.example.usermanagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {


    User getUserByEmail(String email);
}
