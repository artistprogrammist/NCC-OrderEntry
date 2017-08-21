package com.netcracker.courses.oe.catalog.controller;

import com.netcracker.courses.oe.catalog.dto.CategoryDTO;
import com.netcracker.courses.oe.catalog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/catalog/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDTO save(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.save(categoryDTO);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDTO update(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.update(categoryDTO);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryDTO> getAll() {
        return categoryService.getAllCategories();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO get(@PathVariable("id") Long id) {
        return categoryService.getCategory(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        categoryService.delete(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public List<CategoryDTO> saveAll(@RequestBody List<CategoryDTO> categoriesDTO) {
        return categoryService.saveAll(categoriesDTO);
    }
}
