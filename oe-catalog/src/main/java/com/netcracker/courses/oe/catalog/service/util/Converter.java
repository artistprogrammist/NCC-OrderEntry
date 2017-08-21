package com.netcracker.courses.oe.catalog.service.util;

import com.netcracker.courses.oe.catalog.dto.CategoryDTO;
import com.netcracker.courses.oe.catalog.dto.OfferDTO;
import com.netcracker.courses.oe.catalog.dto.TagDTO;
import com.netcracker.courses.oe.catalog.entity.Category;
import com.netcracker.courses.oe.catalog.entity.Filter;
import com.netcracker.courses.oe.catalog.entity.Offer;
import com.netcracker.courses.oe.catalog.entity.Tag;

import java.util.List;
import java.util.Set;

public interface Converter {

    List<OfferDTO> toOffersDTO(List<Offer> offers);

    Offer toOffer(OfferDTO offerDTO);

    OfferDTO toOfferDTO(Offer offer);

    List<Offer> toOffers(List<OfferDTO> productsDTO);

    Category toCategory(CategoryDTO categoryDTO);

    CategoryDTO toCategoryDTO(Category category);

    List<Category> toCategories(List<CategoryDTO> categoriesDTO);

    List<CategoryDTO> toCategoriesDTO(List<Category> categories);

    Tag toTag(TagDTO tagDTO);

    TagDTO toTagDTO(Tag tag);

    List<Tag> toTags(List<TagDTO> tagsDTO);

    List<TagDTO> toTagsDTO(List<Tag> tags);
}
