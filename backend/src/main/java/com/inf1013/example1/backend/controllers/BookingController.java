package com.inf1013.example1.backend.controllers;

import com.inf1013.example1.backend.models.Booking;
import com.inf1013.example1.backend.models.User;
import com.inf1013.example1.backend.services.implementation.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

  @Autowired
  private BookingService bookingService;

  @PostMapping(value="/create")
  public String createBooking(Authentication authentication, @RequestParam(value="offerId") Long offerId,
                                                             @RequestParam(value="date") String date,
                                                              @RequestParam(value="hour") String hour,
                                                             @RequestParam(value="location") String location) {

    Optional<User> user = (Optional<User>) authentication.getPrincipal();

    if(user.isPresent() && user.get().getAccountType().equals("client")) {

      Booking booking = new Booking();
      booking.setClientId(user.get().getId());
      booking.setOfferId(offerId);
      booking.setDate(date);
      booking.setHour(hour);
      booking.setLocation(location);

      bookingService.createBooking(booking);

      return "Booking created";
    }

    return "Error";
  }

}
