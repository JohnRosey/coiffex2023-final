package com.inf1013.example1.backend.models;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;



/**
 * This class represents a user in the database.
 * It is used to store the user's data.
 */
@Data
@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Auto-incremented user id

    private String username = "";
    private String email = "";
    private String password = "";

    private final LocalDateTime creationDate = LocalDateTime.now();
}
