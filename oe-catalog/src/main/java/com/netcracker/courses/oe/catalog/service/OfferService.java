package com.netcracker.courses.oe.catalog.service;

import com.netcracker.courses.oe.catalog.dto.OfferDTO;

import java.util.List;
import java.util.Set;

public interface OfferService {

    OfferDTO save(OfferDTO offerDTO);

    List<OfferDTO> getAllOffers();

    OfferDTO getOffer(Long id);

    OfferDTO update(OfferDTO offerDTO);

    void delete(Long id);

    OfferDTO updateOfferByCategory(Long idOffer, String name);

    OfferDTO updateOfferByTag(Long idOffer, String name);

    OfferDTO deleteOfferByTag(Long idOffer, String name);

    List<OfferDTO> findOffersByFilter(Set<String> tagNames, String priceFrom, String priceTo, String category);
}
