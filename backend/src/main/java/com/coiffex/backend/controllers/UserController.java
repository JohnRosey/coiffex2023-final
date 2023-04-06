package com.coiffex.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.coiffex.backend.dto.LoginDTO;
import com.coiffex.backend.models.User;
import com.coiffex.backend.services.UserService;
import com.coiffex.backend.repositories.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {

        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUsername(username);
        loginDTO.setPassword(password);

        return userService.login(loginDTO) ? "Connecté." : "Identifiants incorrects.";
    }

    @ResponseBody
    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, @RequestParam String email) {

        if (userService.findUserInfoByEmailAdress(email)) {
            return "Cet email est déjà utilisé.";
        }

        User user = new User(username, email, password, "user", "Paris");
        userService.save(user);

        return "Inscription réussie.";
    }
}
