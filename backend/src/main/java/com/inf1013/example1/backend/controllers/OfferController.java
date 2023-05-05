package com.inf1013.example1.backend.controllers;

import com.inf1013.example1.backend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.inf1013.example1.backend.models.Offer;
import com.inf1013.example1.backend.services.implementation.OfferService;

import java.util.Optional;

@RestController
@RequestMapping("/api/offer")
@CrossOrigin(origins = {"https://coiffex.store", "http://localhost:4200"})
public class OfferController {

  @Autowired
  private OfferService offerService;

  @GetMapping(value = "/all")
  public String getAllOffers() {

    int offerCount = 0;
    for (Offer offer : offerService.getOffers()) {
      offer.toJson();
      offerCount++;
    }
    String json = "[";
    for (Offer offer : offerService.getOffers()) {
      json += offer.toJson();
      if (--offerCount > 0) {
        json += ",";
      }
    }
    json += "]";
    return json;
  }


  @PostMapping(value = "/create")
  public String createOffer(@RequestParam(value = "title") String title,
                            @RequestParam(value = "imageUrl") String imageUrl,
                            @RequestParam(value = "description") String description,
                            @RequestParam(value = "duration") int duration,
                            @RequestParam(value = "location") String location,
                            @RequestParam(value = "price") int price,
                            Authentication authentication) { // Get the user from the authentication object

    // Get the user from the authentication object
    Optional<?> principal = (Optional<?>) authentication.getPrincipal();
    if (principal.isPresent() && principal.get() instanceof User) {
      User user = (User) principal.get();

      if (user.getAccountType().equals("hairdresser")) {
        Offer offer = new Offer();
        offer.setTitle(title);
        offer.setDescription(description);
        offer.setImageUrl(imageUrl);
        offer.setDuration(duration);
        offer.setLocation(location);
        offer.setGrade(5);
        offer.setPrice(price);
        offer.setHairdresserId(user.getId());

        offerService.createOffer(offer);
        return "Offer created";
      }
    }

    return "An error occurred";
  }

}

