package com.example.usermanagemennt.repository;

import com.example.usermanagemennt.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {


    User getUserByEmail(String email);
}
