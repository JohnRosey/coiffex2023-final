package com.inf1013.example1.backend.controllers;

import com.inf1013.example1.backend.configuration.UserAuthenticationProvider;
import com.inf1013.example1.backend.dto.UserTokenCreation;
import com.inf1013.example1.backend.models.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.inf1013.example1.backend.dto.UserLogin;
import com.inf1013.example1.backend.dto.UserRegistration;
import com.inf1013.example1.backend.services.implementation.AuthentificationService;

import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.Option;
import java.util.Optional;


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

      Long userId = authentificationService.findIdByUsername(username);

      UserTokenCreation userTokenCreation = new UserTokenCreation();
      userTokenCreation.setUsername(username);
      userTokenCreation.setUserId(userId);

      String token = userAuthenticationProvider.createToken(userTokenCreation);
      return token;
    }

    @GetMapping(value="/details")
    public String details(Authentication authentication) {

      Optional<User> user = (Optional<User>) authentication.getPrincipal();

      if(user.isPresent()) {
        //Return all users info to json format
        return "{" +
          "\"username\": \"" + user.get().getUsername() + "\"," +
          "\"email\": \"" + user.get().getEmail() + "\"," +
          "\"accountType\": \"" + user.get().getAccountType() + "\"" +
          "\"creationDate\": \"" + user.get().getCreationDate() + "\"" +
        "}";
      }

      return "Error";
    }
}
