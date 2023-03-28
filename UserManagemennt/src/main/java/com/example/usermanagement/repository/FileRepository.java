package com.example.usermanagement.repository;

import com.example.usermanagement.entities.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, String> {

}
