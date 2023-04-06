package com.coiffex.backend.models;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String emailAdress;
    private String password;

    private String location;
    private String accountType;

    public User(String name, String emailAdress, String password, String accountType, String location) {
        this.name = name;
        this.emailAdress = emailAdress;
        this.password = password;
        this.accountType = accountType;
        this.location = location;
    }
}
