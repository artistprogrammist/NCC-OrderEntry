package com.netcracker.courses.oe.catalog.service;

import com.netcracker.courses.oe.catalog.dto.OfferDTO;
import com.netcracker.courses.oe.catalog.entity.Category;
import com.netcracker.courses.oe.catalog.entity.Offer;
import com.netcracker.courses.oe.catalog.exception.EntityNotFoundException;
import com.netcracker.courses.oe.catalog.repository.CategoryRepository;
import com.netcracker.courses.oe.catalog.repository.OfferRepository;
import com.netcracker.courses.oe.catalog.service.OfferService;
import com.netcracker.courses.oe.catalog.service.helper.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SimpleOfferService implements OfferService {

    private final OfferRepository offerRepository;

    private final CategoryRepository categoryRepository;

    private final Converter converter;

    @Autowired
    public SimpleOfferService(OfferRepository offerRepository, CategoryRepository categoryRepository, Converter converter) {
        this.offerRepository = offerRepository;
        this.categoryRepository = categoryRepository;
        this.converter = converter;
    }

    @Override
    public OfferDTO save(OfferDTO offerDTO) {
        Offer offer = converter.toOffer(offerDTO);
        Category category = categoryRepository.findFirstByName(offerDTO.getCategory());
        if (category == null || category.getName().equals(offer.getCategory())) {
            Category categorySave = categoryRepository.save(new Category(offerDTO.getCategory()));
            offer.setCategory(categorySave);
        } else {
            offer.setCategory(category);
        }
        Offer saveOffer = offerRepository.save(offer);
        return converter.toOfferDTO(saveOffer);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OfferDTO> getAllOffers() {
        List<Offer> allOffers = offerRepository.findAll();
        List<OfferDTO> productsDTO = converter.toOffersDTO(allOffers);
        return productsDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public OfferDTO getOffer(Long id) {
        Offer offer = offerRepository.findOne(id);
        return converter.toOfferDTO(offer);
    }

    @Override
    public OfferDTO update(OfferDTO offerDTO) {
        return save(offerDTO);
    }

    @Override
    public void delete(Long id) {
        try {
            offerRepository.delete(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    @Override
    public List<OfferDTO> getOffersByCategory(String name) {
        Category category = categoryRepository.findFirstByName(name);
        List<Offer> allByCategory = offerRepository.findAllByCategory(category);
        return converter.toOffersDTO(allByCategory);
    }
}
