package com.example.usermanagemennt.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.util.UUID;

public class User {
    @Id
    private UUID userId;


    @Column(name="name")
    private String name;


    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
