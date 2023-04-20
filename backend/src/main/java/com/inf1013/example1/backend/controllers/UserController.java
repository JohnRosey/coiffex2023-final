package com.inf1013.example1.backend.controllers;

import org.springframework.web.bind.annotation.*;

import com.inf1013.example1.backend.dto.UserLogin;
import com.inf1013.example1.backend.dto.UserRegistration;
import com.inf1013.example1.backend.services.implementation.AuthentificationService;

import org.springframework.beans.factory.annotation.Autowired;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private AuthentificationService authentificationService;

    @PostMapping(value="/register")
    public String register(@RequestBody UserRegistration user) {

       user.setUsername(user.getUsername());
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());


        return authentificationService.createUser(user);
    }

    @PostMapping(value="/login")
    public String login(@RequestBody UserLogin user) {
       user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());


        return authentificationService.login(user);
    }
}
