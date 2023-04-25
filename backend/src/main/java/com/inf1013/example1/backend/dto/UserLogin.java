package com.inf1013.example1.backend.dto;

import lombok.Data;

// This DTO represents the user login
@Data
public class UserLogin {
    private String username = "";
    private String password = "";
}
