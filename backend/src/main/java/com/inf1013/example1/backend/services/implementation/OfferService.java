package com.inf1013.example1.backend.services.implementation;

import com.inf1013.example1.backend.services.OfferServiceInterface;
import org.springframework.stereotype.Service;

import java.lang.Iterable;
import com.inf1013.example1.backend.models.Offer;
import com.inf1013.example1.backend.repositories.OfferRepository;

import org.springframework.beans.factory.annotation.Autowired;


@Service
public class OfferService implements OfferServiceInterface {

    @Autowired
    private OfferRepository offerRepository;

    @Override
    public Iterable<Offer> getOffers() {
        return offerRepository.findAll();
    }

  public void createOffer(Offer offer) {
    offerRepository.save(offer);
  }
}
