package com.inf1013.example1.backend.repositories;

import org.springframework.data.repository.CrudRepository;

import com.inf1013.example1.backend.models.Offer;

import java.util.Optional;
import java.lang.Iterable;

/**
 * This class allow us to access the database and perform CRUD operations on the users table.
 */
public interface OfferRepository extends CrudRepository<Offer, String> {

    Iterable<Offer> findAll();

    /**
     * This method is used to find a user by its id.
     * @param id The user id
     * @return The user with the given id
     */
    Optional<Offer> findOfferById(Long id);
    
    Optional<Offer> findOfferByHairdresserId(Long hairdresserId);

    Optional<Offer> findOfferByLocation(String location);    
}
