package com.coiffex.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldContreller {
    
    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }
}
