package com.coiffex.backend;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.coiffex.backend.models.User;

@RestController
public class UserController {

    @ResponseBody
    @PostMapping("/user/login")
    public String login(User user) {
        return "hello";
    }

    @ResponseBody
    @PostMapping("/user/register")
    public String register(User user) {
        return user.getName();
    }
    
}
