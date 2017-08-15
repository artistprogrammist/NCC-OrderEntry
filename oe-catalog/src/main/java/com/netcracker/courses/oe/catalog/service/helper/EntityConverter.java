package com.netcracker.courses.oe.catalog.service.helper;

import com.netcracker.courses.oe.catalog.dto.OfferDTO;
import com.netcracker.courses.oe.catalog.entity.Category;
import com.netcracker.courses.oe.catalog.entity.Offer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class EntityConverter implements Converter {

    @Override
    public List<OfferDTO> toOffersDTO(List<Offer> offers) {
        List<OfferDTO> productsDTO = new ArrayList<>();
        if (offers != null) {
            offers.forEach(product -> {
                productsDTO.add(toOfferDTO(product));
            });
        }
        return productsDTO;
    }

    @Override
    public List<Offer> toOffers(List<OfferDTO> productsDTO) {
        List<Offer> offers = new ArrayList<>();
        if (productsDTO != null) {
            productsDTO.forEach(productDTO -> {
                offers.add(toOffer(productDTO));
            });
        }
        return offers;
    }

    @Override
    public Offer toOffer(OfferDTO offerDTO) {
        Offer offer = new Offer();
        if (offerDTO != null) {
            offer.setId(offerDTO.getId());
            offer.setPrice(offerDTO.getPrice());
            offer.setBarcode(offerDTO.getBarcode());
            offer.setProducer(offerDTO.getProducer());
            offer.setName(offerDTO.getName());
            Category category = new Category();
            category.setName(offerDTO.getName());
            category.setOffers(Collections.singletonList(offer));
            offer.setCategory(category);
        }
        return offer;
    }

    @Override
    public OfferDTO toOfferDTO(Offer offer) {
        OfferDTO offerDTO = new OfferDTO();
        if (offer != null) {
            offerDTO.setPrice(offer.getPrice());
            offerDTO.setId(offer.getId());
            offerDTO.setBarcode(offer.getBarcode());
            offerDTO.setName(offer.getName());
            offerDTO.setProducer(offer.getProducer());
            offerDTO.setCategory(offer.getCategory().getName());
        }
        return offerDTO;
    }
}
