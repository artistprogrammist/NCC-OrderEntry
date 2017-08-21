package com.netcracker.courses.oe.catalog.repository;

import com.netcracker.courses.oe.catalog.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Long> {
}
