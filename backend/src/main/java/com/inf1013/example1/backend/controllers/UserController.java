package com.inf1013.example1.backend.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.inf1013.example1.backend.dto.UserLogin;
import com.inf1013.example1.backend.dto.UserRegistration;
import com.inf1013.example1.backend.services.implementation.AuthentificationService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private AuthentificationService authentificationService;

    @PostMapping(value="/register")
    public String register(@RequestParam(value="username") String username,
                           @RequestParam(value="email") String email,
                           @RequestParam(value="password") String password) {
        
        UserRegistration user = new UserRegistration();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        return authentificationService.createUser(user);
    }

    @PostMapping(value="/login")
    public String login(@RequestParam(value="username") String username,
                        @RequestParam(value="password") String password) {
        
        UserLogin user = new UserLogin();
        user.setUsername(username);
        user.setPassword(password);

        return authentificationService.login(user);
    }
}
