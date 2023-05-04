package com.inf1013.example1.backend.services.implementation;

import com.inf1013.example1.backend.models.Booking;
import com.inf1013.example1.backend.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

  @Autowired
  private BookingRepository bookingRepository;

  public void createBooking(Booking booking) {
    bookingRepository.save(booking);
  }
}
