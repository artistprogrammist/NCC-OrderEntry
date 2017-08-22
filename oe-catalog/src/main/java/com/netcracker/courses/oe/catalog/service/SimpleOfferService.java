package com.netcracker.courses.oe.catalog.service;

import com.netcracker.courses.oe.catalog.dto.OfferDTO;
import com.netcracker.courses.oe.catalog.entity.Category;
import com.netcracker.courses.oe.catalog.entity.Filter;
import com.netcracker.courses.oe.catalog.entity.Offer;
import com.netcracker.courses.oe.catalog.entity.Tag;
import com.netcracker.courses.oe.catalog.exception.EntityNotFoundException;
import com.netcracker.courses.oe.catalog.repository.CategoryRepository;
import com.netcracker.courses.oe.catalog.repository.OfferRepository;
import com.netcracker.courses.oe.catalog.repository.PriceRepository;
import com.netcracker.courses.oe.catalog.repository.TagRepository;
import com.netcracker.courses.oe.catalog.service.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class SimpleOfferService implements OfferService {

    private final OfferRepository offerRepository;

    private final CategoryRepository categoryRepository;

    private final PriceRepository priceRepository;

    private final TagRepository tagRepository;

    private final Converter converter;

    @Autowired
    public SimpleOfferService(OfferRepository offerRepository, CategoryRepository categoryRepository, PriceRepository priceRepository, TagRepository tagRepository, Converter converter) {
        this.offerRepository = offerRepository;
        this.categoryRepository = categoryRepository;
        this.priceRepository = priceRepository;
        this.tagRepository = tagRepository;
        this.converter = converter;
    }

    @Override
    public OfferDTO save(OfferDTO offerDTO) {
        Offer offer = converter.toOffer(offerDTO);
        Category category = categoryRepository.findFirstByName(offerDTO.getCategory());
        if (category == null || category.getName().equals(offer.getCategory().getName())) {
            Category categorySave = categoryRepository.save(new Category(offerDTO.getCategory()));
            offer.setCategory(categorySave);
        } else {
            offer.setCategory(category);
        }
        List<Tag> tags = new ArrayList<>();
        if (offer.getTags() != null) {
            offer.getTags().forEach(tag -> {
                Tag tagByName = tagRepository.findFirstByName(tag.getName());
                if (tagByName == null || !(tagByName.getName().equals(tag.getName()))) {
                    Tag tagSave = tagRepository.save(tag);
                    tags.add(tagSave);
                } else {
                    tags.add(tagByName);
                }
            });
            offer.setTags(tags);
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
    public OfferDTO updateOfferByCategory(Long idOffer, String name) {
        Offer offer = offerRepository.getOne(idOffer);
        Category firstByName = categoryRepository.findFirstByName(name);
        offer.setCategory(firstByName);
        Offer save = offerRepository.save(offer);
        return converter.toOfferDTO(save);
    }

    @Override
    public OfferDTO updateOfferByTag(Long idOffer, String name) {
        Offer offer = offerRepository.getOne(idOffer);
        Tag firstByName = tagRepository.findFirstByName(name);
        offer.getTags().add(firstByName);
        Offer save = offerRepository.save(offer);
        return converter.toOfferDTO(save);
    }

    @Override
    public OfferDTO deleteOfferByTag(Long idOffer, String name) {
        Offer offer = offerRepository.getOne(idOffer);
        Tag firstByName = tagRepository.findFirstByName(name);
        offer.getTags().remove(firstByName);
        Offer save = offerRepository.save(offer);
        return converter.toOfferDTO(save);
    }

    @Override
    public List<OfferDTO> findOffersByFilter(Set<String> tagNames, String priceFrom, String priceTo, String category) {
        //todo impl new filtering price
        List<Offer> offers = new ArrayList<>();
        List<Offer> all = new ArrayList<>();
        Filter filter = createFilter(tagNames, priceFrom, priceTo, category);
        if (filter.getCategory() != null) {
            all.addAll(offerRepository.findAllByCategoryOrTags(filter.getCategory(), filter.getTags()));
        } else {
            all.addAll(offerRepository.findAllByTags(filter.getTags()));
        }
        all.forEach(offer -> {
            double currencyValue = offer.getPrice().getCurrencyValue();
            if (currencyValue >= filter.getPriceFrom() && currencyValue <= filter.getPriceTo()) {
                offers.add(offer);
            }
        });
        return converter.toOffersDTO(offers);
    }

    private Filter createFilter(Set<String> tagNames, String priceFrom, String priceTo, String category) {
        Filter filter = new Filter();
        List<Tag> tags = new ArrayList<>();
        if (tagNames != null) {
            tagNames.forEach(name -> {
                Tag firstByName = tagRepository.findFirstByName(name);
                tags.add(firstByName);
            });
        }
        filter.setTags(tags);
        if (category != null) {
            Category firstByName = categoryRepository.findFirstByName(category);
            filter.setCategory(firstByName);
        }
        if (priceFrom != null) {
            filter.setPriceFrom(Double.valueOf(priceFrom));
        } else {
            filter.setPriceFrom(0D);
        }
        if (priceTo != null) {
            filter.setPriceTo(Double.valueOf(priceTo));
        } else {
            filter.setPriceTo(Double.MAX_VALUE);
        }
        return filter;
    }
}
