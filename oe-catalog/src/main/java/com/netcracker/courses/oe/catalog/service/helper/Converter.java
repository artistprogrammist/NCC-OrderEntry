package com.netcracker.courses.oe.catalog.service.helper;

import com.netcracker.courses.oe.catalog.dto.OfferDTO;
import com.netcracker.courses.oe.catalog.entity.Offer;

import java.util.List;

public interface Converter {

    List<OfferDTO> toOffersDTO(List<Offer> offers);

    Offer toOffer(OfferDTO offerDTO);

    OfferDTO toOfferDTO(Offer offer);

    List<Offer> toOffers(List<OfferDTO> productsDTO);
}
