package com.coiffex.backend.repositories;

import com.coiffex.backend.models.User;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByName(String name);

    Optional<User> findUserInfoByEmailAdress(String email);

    Optional<User> findUserInfoById(Long id);

    @Query(name="SELECT * FROM users  WHERE name ILIKE '%:key%'" , nativeQuery = true)
    List<User> findUsersByName(@Param("key") String searchKey);
}
