package com.inf1013.example1.backend.services.implementation;

import com.inf1013.example1.backend.models.Booking;
import com.inf1013.example1.backend.models.Offer;
import com.inf1013.example1.backend.repositories.BookingRepository;
import com.inf1013.example1.backend.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

  @Autowired
  private BookingRepository bookingRepository;

  @Autowired
  private OfferRepository offerRepository;

  public void createBooking(Booking booking) {
    bookingRepository.save(booking);
  }

  public List<Booking> getBookingsByHairdresserId(Long id) {
    List<Booking> results = new ArrayList<Booking>();

    for(Booking booking : bookingRepository.findAll()) {
     Offer offer = offerRepository.findOfferById(booking.getOfferId()).get();

      if(offer.getHairdresserId().equals(id)) {
        results.add(booking);
      }
    }

    return results;
  }

  public void validateBooking(Long bookingId) {
    Booking booking = bookingRepository.findBookingById(bookingId).get();
    booking.setValidated(true);
    bookingRepository.save(booking);
  }
}
