package com.netcracker.courses.oe.catalog.service.util;

import com.netcracker.courses.oe.catalog.dto.CategoryDTO;
import com.netcracker.courses.oe.catalog.dto.OfferDTO;
import com.netcracker.courses.oe.catalog.dto.TagDTO;
import com.netcracker.courses.oe.catalog.entity.Category;
import com.netcracker.courses.oe.catalog.entity.Offer;
import com.netcracker.courses.oe.catalog.entity.Price;
import com.netcracker.courses.oe.catalog.entity.Tag;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public Category toCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        if (categoryDTO != null) {
            category.setName(categoryDTO.getName());
            category.setId(categoryDTO.getId());
        }
        return category;
    }

    @Override
    public CategoryDTO toCategoryDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        if (category != null) {
            categoryDTO.setId(category.getId());
            categoryDTO.setName(category.getName());
        }
        return categoryDTO;
    }


    @Override
    public List<Category> toCategories(List<CategoryDTO> categoriesDTO) {
        List<Category> categories = new ArrayList<>();
        categoriesDTO.forEach(categoryDTO -> {
            categories.add(toCategory(categoryDTO));
        });
        return categories;
    }

    @Override
    public List<CategoryDTO> toCategoriesDTO(List<Category> categories) {
        List<CategoryDTO> categoriesDTO = new ArrayList<>();
        categories.forEach(category -> {
            categoriesDTO.add(toCategoryDTO(category));
        });
        return categoriesDTO;
    }

    @Override
    public Tag toTag(TagDTO tagDTO) {
        Tag tag = new Tag();
        if (tagDTO != null) {
            tag.setName(tagDTO.getName());
            tag.setId(tagDTO.getId());
        }
        return tag;
    }

    @Override
    public TagDTO toTagDTO(Tag tag) {
        TagDTO tagDTO = new TagDTO();
        if (tag != null) {
            tagDTO.setId(tag.getId());
            tagDTO.setName(tag.getName());
        }
        return tagDTO;
    }

    @Override
    public List<Tag> toTags(List<TagDTO> tagsDTO) {
        List<Tag> tags = new ArrayList<>();
        tagsDTO.forEach(tagDTO -> {
            tags.add(toTag(tagDTO));
        });
        return tags;
    }

    @Override
    public List<TagDTO> toTagsDTO(List<Tag> tags) {
        List<TagDTO> tagsDTO = new ArrayList<>();
        tags.forEach(tag -> {
            tagsDTO.add(toTagDTO(tag));
        });
        return tagsDTO;
    }

    @Override
    public Offer toOffer(OfferDTO offerDTO) {
        Offer offer = new Offer();
        if (offerDTO != null) {
            offer.setId(offerDTO.getId());
            offer.setBarcode(offerDTO.getBarcode());
            offer.setProducer(offerDTO.getProducer());
            offer.setName(offerDTO.getName());
            Price price = new Price();
            price.setCurrencyValue(offerDTO.getPrice());
            offer.setPrice(price);
            price.setOffer(offer);
            Category category = new Category();
            category.setName(offerDTO.getName());
            offer.setCategory(category);
            List<Tag> tags = new ArrayList<>();
            offerDTO.getTags().forEach(name -> {
                Tag tag = new Tag();
                tag.setName(name);
                tags.add(tag);
            });
            offer.setTags(tags);
        }
        return offer;
    }

    @Override
    public OfferDTO toOfferDTO(Offer offer) {
        OfferDTO offerDTO = new OfferDTO();
        if (offer != null) {
            offerDTO.setId(offer.getId());
            offerDTO.setBarcode(offer.getBarcode());
            offerDTO.setName(offer.getName());
            offerDTO.setProducer(offer.getProducer());
            offerDTO.setCategory(offer.getCategory().getName());
            offerDTO.setPrice(offer.getPrice().getCurrencyValue());
            offerDTO.setTags(offer.getTags().stream().map(Tag::getName).collect(Collectors.toList()));
        }
        return offerDTO;
    }
}
