package com.netcracker.courses.oe.catalog.service;

import com.netcracker.courses.oe.catalog.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    CategoryDTO save(CategoryDTO categoryDTO);

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategory(Long id);

    CategoryDTO update(CategoryDTO categoryDTO);

    void delete(Long id);

    List<CategoryDTO> saveAll(List<CategoryDTO> categoriesDTO);
}
