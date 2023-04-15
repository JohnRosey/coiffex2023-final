package com.inf1013.example1.backend.dto;

import lombok.Data;


/**
 * This class represents a user registration.
 */
@Data
public class UserRegistration {

    private long id;
    private String username = "";
    private String email = "";
    private String password = "";
}
