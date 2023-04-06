package com.coiffex.backend.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.coiffex.backend.models.User;

@RestController
@RequestMapping("/user")
public class UserController {


    @ResponseBody
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        return "Username: " + username + " Password: " + password;
    }

    @ResponseBody
    @PostMapping("/register")
    public String register(User user) {
        return user.getName();
    }

}
