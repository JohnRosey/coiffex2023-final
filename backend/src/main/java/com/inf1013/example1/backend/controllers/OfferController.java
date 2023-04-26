package com.inf1013.example1.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.inf1013.example1.backend.models.Offer;
import com.inf1013.example1.backend.services.implementation.OfferService;

@RestController
@RequestMapping("/api/offer")
@CrossOrigin(origins = "https://coiffex.store")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @GetMapping(value="/all")
    public String getAllOffers() {

        int offerCount = 0;
        for (Offer offer : offerService.getOffers()) {
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

    
}
