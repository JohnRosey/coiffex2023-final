package com.inf1013.example1.backend.controllers;

import com.inf1013.example1.backend.models.Booking;
import com.inf1013.example1.backend.models.User;
import com.inf1013.example1.backend.services.implementation.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
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

  @GetMapping(value="/my-bookings")
  public List<Booking> getBookingsByHairdresserId(Authentication authentication) {

    Optional<User> user = (Optional<User>) authentication.getPrincipal();

    if(user.isPresent() && user.get().getAccountType().equals("hairdresser")) {
      System.out.println("Hairdresser id: " + user.get().getId());

      return bookingService.getBookingsByHairdresserId(user.get().getId());
    }

    System.out.println("Error");

    return null;
  }

  @PostMapping(value="/validate")
  public void validateBooking(Authentication authentication, @RequestParam(value="bookingId") Long bookingId) {

    Optional<User> user = (Optional<User>) authentication.getPrincipal();

    if(user.isPresent() && user.get().getAccountType().equals("hairdresser")) {

      bookingService.validateBooking(bookingId);
    }
  }
}
