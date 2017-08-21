package com.netcracker.courses.oe.catalog.repository;

import com.netcracker.courses.oe.catalog.entity.Category;
import com.netcracker.courses.oe.catalog.entity.Offer;
import com.netcracker.courses.oe.catalog.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Long>, OfferRepositoryCustom {

    List<Offer> findAllByCategory(Category category);

    List<Offer> findAllByCategoryOrTags(Category category, List<Tag> tags);

    List<Offer> findAllByTags(List<Tag> tags);
}
