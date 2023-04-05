package com.coiffex.backend.repositories;

import com.coiffex.backend.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {

    Optional<User> findUserInfoByEmail(String email);

    Optional<User> findUserInfoById(Long id);

    @Query("SELECT user FROM User user WHERE user.name LIKE %:key%")
    List<User> findUsersByName(@Param("key") String searchKey);
}
