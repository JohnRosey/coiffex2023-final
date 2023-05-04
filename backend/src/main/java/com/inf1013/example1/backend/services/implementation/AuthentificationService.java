package com.inf1013.example1.backend.services.implementation;

import org.springframework.stereotype.Service;

import com.inf1013.example1.backend.dto.UserLogin;
import com.inf1013.example1.backend.dto.UserRegistration;
import com.inf1013.example1.backend.models.User;
import com.inf1013.example1.backend.repositories.UserRepository;
import com.inf1013.example1.backend.services.AuthentificationServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Service
public class AuthentificationService implements AuthentificationServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String createUser(UserRegistration userRegistration) {

        if(userRepository.findUserByUsername(userRegistration.getUsername()).isPresent()) {
            return "Username already exists";
        }

        if(userRepository.findUserByEmail(userRegistration.getEmail()).isPresent()) {
            return "Email already exists";
        }

        User user = new User();
        user.setUsername(userRegistration.getUsername());
        user.setEmail(userRegistration.getEmail());
        user.setPassword(HashingService.hashPassword(userRegistration.getPassword()));
        user.setAccountType(userRegistration.getAccountType());
        userRepository.save(user);

        return "User created successfully. Welcome " + userRegistration.getUsername() + " !";
    }

    @Override
    public User login(UserLogin userLogin) {

        if(!userRepository.findUserByUsername(userLogin.getUsername()).isPresent()) {
          System.out.println("User not found");
          throw new RuntimeException("Invalid credentials");
        }

        User user = userRepository.findUserByUsername(userLogin.getUsername()).get();

        if(!HashingService.checkPassword(userLogin.getPassword(), user.getPassword())) {
            System.out.println("Wrong password");
            throw new RuntimeException("Invalid credentials");
        }

        System.out.println("User found");
        return user;
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public Long findIdByUsername(String username) {
        return userRepository.findIdByUsername(username);
    }

  public User findById(Long id) {
    return userRepository.findUserById(id).get();
  }
}
