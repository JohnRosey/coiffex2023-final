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
@Table(name = "offers")
public class Offer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Auto-incremented offer id

    private String title = "";
    private String description = "";
    
    private Long hairdresserId;

    private int grade;
    private int price;
    private int duration;

    private String imageUrl = "";
    private String location = "";

    private final LocalDateTime creationDate = LocalDateTime.now(); 
    // The date when the offer was created

    public String toJson() {
        return "{" +
            "\"id\":" + id + "," +
            "\"title\":\"" + title + "\"," +
            "\"description\":\"" + description + "\"," +
            "\"hairdresser\":" + "\"John Doe\"" + "," +
            "\"grade\":" + grade + "," +
            "\"price\":" + price + "," +
            "\"duration\":" + duration + "," +
            "\"imageURL\":\"" + imageUrl + "\"," +
            "\"location\":\"" + location + "\"," +
            "\"creationDate\":\"" + creationDate + "\"" +
        "}";
    }
}
