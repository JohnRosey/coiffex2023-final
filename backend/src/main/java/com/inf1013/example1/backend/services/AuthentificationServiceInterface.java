package com.inf1013.example1.backend.services;

import com.inf1013.example1.backend.dto.UserLogin;
import com.inf1013.example1.backend.dto.UserRegistration;

/**
 * This interface represents the authentification service.
 * It is used to register and login a user.
 */
public interface AuthentificationServiceInterface {

    /**
     * Register a new user
     * @param userRegistration
     * @return String message
     */
    String createUser(UserRegistration userRegistration);

    /**
     * Log a user
     * @param userLogin
     * @return
     */
    String login(UserLogin userLogin);
}
