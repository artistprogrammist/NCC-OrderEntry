package com.netcracker.courses.oe.catalog.service;

import com.netcracker.courses.oe.catalog.dto.CategoryDTO;
import com.netcracker.courses.oe.catalog.entity.Category;
import com.netcracker.courses.oe.catalog.repository.CategoryRepository;
import com.netcracker.courses.oe.catalog.service.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleCategoryService implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final Converter converter;

    @Autowired
    public SimpleCategoryService(CategoryRepository categoryRepository, Converter converter) {
        this.categoryRepository = categoryRepository;
        this.converter = converter;
    }

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        Category category = converter.toCategory(categoryDTO);
        Category saveCategory = categoryRepository.save(category);
        return converter.toCategoryDTO(saveCategory);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return converter.toCategoriesDTO(categoryRepository.findAll());
    }

    @Override
    public CategoryDTO getCategory(Long id) {
        return converter.toCategoryDTO(categoryRepository.findOne(id));
    }

    @Override
    public CategoryDTO update(CategoryDTO categoryDTO) {
        return save(categoryDTO);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.delete(id);
    }

    @Override
    public List<CategoryDTO> saveAll(List<CategoryDTO> categoriesDTO) {
        List<Category> categories = converter.toCategories(categoriesDTO);
        List<Category> save = categoryRepository.save(categories);
        return converter.toCategoriesDTO(save);
    }
}
