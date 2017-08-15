package com.netcracker.courses.oe.catalog.service;

import com.netcracker.courses.oe.catalog.dto.OfferDTO;

import java.util.List;

public interface OfferService {

    OfferDTO save(OfferDTO offerDTO);

    List<OfferDTO> getAllOffers();

    OfferDTO getOffer(Long id);

    OfferDTO update(OfferDTO offerDTO);

    void delete(Long id);

    List<OfferDTO> getOffersByCategory(String name);
}
