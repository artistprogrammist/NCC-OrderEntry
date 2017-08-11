package com.netcracker.courses.oe.repository.catalog;

import com.netcracker.courses.oe.entity.catalog.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findFirstByName(String name);
}
