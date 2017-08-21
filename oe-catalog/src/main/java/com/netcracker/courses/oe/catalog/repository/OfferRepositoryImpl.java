package com.netcracker.courses.oe.catalog.repository;

import com.netcracker.courses.oe.catalog.entity.Filter;
import com.netcracker.courses.oe.catalog.entity.Offer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class OfferRepositoryImpl implements OfferRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Offer> findOffersByFilter(Filter filter) {
        //todo реализация
        return null;
    }
}
