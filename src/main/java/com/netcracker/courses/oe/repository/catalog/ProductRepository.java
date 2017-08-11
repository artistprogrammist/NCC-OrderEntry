package com.netcracker.courses.oe.repository.catalog;

import com.netcracker.courses.oe.entity.catalog.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
