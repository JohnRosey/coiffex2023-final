package com.inf1013.example1.backend.repositories;

import org.springframework.data.repository.CrudRepository;

import com.inf1013.example1.backend.models.User;

import java.util.Optional;

/**
 * This class allow us to access the database and perform CRUD operations on the users table.
 */
public interface UserRepository extends CrudRepository<User, String> {

    Optional<User> findUserById(Long id);

    Optional<User> findUserByEmail(String email);

    Optional<User> findUserByUsername(String username);
}
