package com.inf1013.example1.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;

import com.inf1013.example1.backend.models.User;

import java.util.Optional;

/**
 * This class allow us to access the database and perform CRUD operations on the users table.
 */
public interface UserRepository extends CrudRepository<User, String> {

    /**
     * This method is used to find a user by its id.
     * @param id The user id
     * @return The user with the given id
     */
    Optional<User> findUserById(Long id);

    /**
     * This method is used to find a user by its email.
     * @param email The user email
     * @return The user with the given email
     */
    Optional<User> findUserByEmail(String email);

    /**
     * This method is used to find a user by its username.
     * @param username The user username
     * @return The user with the given username
     */
    Optional<User> findUserByUsername(@PathVariable String username);
}
