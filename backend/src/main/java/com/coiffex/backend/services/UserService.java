package com.coiffex.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coiffex.backend.models.User;
import com.coiffex.backend.dto.LoginDTO;
import com.coiffex.backend.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean login(LoginDTO loginDTO) {
        User user = userRepository.findByName(loginDTO.getUsername()).orElse(null);

        if (user == null) {
            return false;
        }

        return user.getPassword().equals(loginDTO.getPassword());
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public boolean findUserInfoByEmailAdress(String email) {
        return userRepository.findUserInfoByEmailAdress(email).isPresent();
    }

    public boolean findUserInfoById(Long id) {
        return userRepository.findUserInfoById(id).isPresent();
    }

    public boolean findUsersByName(String searchKey) {
        return userRepository.findUsersByName(searchKey).size() > 0;
    }   
}
