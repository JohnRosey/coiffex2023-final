package com.inf1013.example1.backend.services;

import com.inf1013.example1.backend.models.Offer;

import java.lang.Iterable;

public interface OfferServiceInterface {

    //Get all from database
    Iterable<Offer> getOffers();
}
