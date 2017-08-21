package com.netcracker.courses.oe.catalog.repository;

import com.netcracker.courses.oe.catalog.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findFirstByName(String name);
}
