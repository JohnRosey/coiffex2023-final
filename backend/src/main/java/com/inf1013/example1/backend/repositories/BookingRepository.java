package com.inf1013.example1.backend.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inf1013.example1.backend.models.Booking;

@Repository
public interface BookingRepository extends CrudRepository<Booking, String> {


    Iterable<Booking> findAll();

    Optional<Booking> findBookingById(Long id);

    Optional<Booking> findBookingByClientId(Long userId);

    Optional<Booking> findBookingByOfferId(Long offerId);


}
