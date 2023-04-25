package com.inf1013.example1.backend.services;

import com.inf1013.example1.backend.dto.Offer;
import com.inf1013.example1.backend.dto.OfferSearch;

import java.util.List;

public interface OfferServiceInterface {

    List<Offer> getOffers();

    String updateOffer(OfferSearch offerSearch);

    String deleteOffer(OfferSearch offerSearch);
}
