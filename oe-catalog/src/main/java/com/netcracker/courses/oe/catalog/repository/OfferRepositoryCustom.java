package com.netcracker.courses.oe.catalog.repository;

import com.netcracker.courses.oe.catalog.entity.Filter;
import com.netcracker.courses.oe.catalog.entity.Offer;

import java.util.List;

public interface OfferRepositoryCustom {
    List<Offer> findOffersByFilter(Filter filter);
}
