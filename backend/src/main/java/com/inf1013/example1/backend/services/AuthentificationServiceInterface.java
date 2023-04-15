package com.inf1013.example1.backend.services;

import com.inf1013.example1.backend.dto.UserLogin;
import com.inf1013.example1.backend.dto.UserRegistration;

public interface AuthentificationServiceInterface {

    String createUser(UserRegistration userRegistration);

    String login(UserLogin userLogin);
}
