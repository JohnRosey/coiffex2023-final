package com.inf1013.example1.backend.controllers;

import com.inf1013.example1.backend.configuration.UserAuthenticationProvider;
import org.springframework.web.bind.annotation.*;

import com.inf1013.example1.backend.dto.UserLogin;
import com.inf1013.example1.backend.dto.UserRegistration;
import com.inf1013.example1.backend.services.implementation.AuthentificationService;

import org.springframework.beans.factory.annotation.Autowired;


@CrossOrigin(origins = "http://localhost:4200")

/**
 * UserController
 * Handles the user registration and login
 */

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private AuthentificationService authentificationService;

    @Autowired
    private UserAuthenticationProvider userAuthenticationProvider;

    /**
     * Register a new user
     * @param username
     * @param email
     * @return String message
     */
    @PostMapping(value="/register")
    public String register(@RequestParam(value="username") String username,
                           @RequestParam(value="email") String email,
                           @RequestParam(value="password") String password,
                           @RequestParam(value="accountType") String accountType) {

        UserRegistration user = new UserRegistration();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setAccountType(accountType);


        return authentificationService.createUser(user);
    }

    /**
     * Log a user
     * @param username
     * @param password
     * @return
     */
    @PostMapping(value="/login")
    public String login(@RequestParam(value="username") String username,
                        @RequestParam(value="password") String password) {

      System.out.println("login");
      System.out.println(username);
      System.out.println(password);

        UserLogin user = new UserLogin();
        user.setUsername(username);
        user.setPassword(password);

        String token = userAuthenticationProvider.createToken(username);
        return token;
    }

    @GetMapping(value="/details")
    public String details() {
        return "User details";
    }
}
