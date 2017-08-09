package com.netcracker.courses.oe.repository.catalog;

import com.netcracker.courses.oe.entity.catalog.Product;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<Product, Long> {



}
