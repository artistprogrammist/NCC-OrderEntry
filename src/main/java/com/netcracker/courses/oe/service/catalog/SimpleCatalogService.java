package com.netcracker.courses.oe.service.catalog;

import com.netcracker.courses.oe.dto.catalog.ProductDTO;
import com.netcracker.courses.oe.entity.catalog.Category;
import com.netcracker.courses.oe.entity.catalog.Product;
import com.netcracker.courses.oe.exception.EntityNotFoundException;
import com.netcracker.courses.oe.repository.catalog.CategoryRepository;
import com.netcracker.courses.oe.repository.catalog.ProductRepository;
import com.netcracker.courses.oe.service.CatalogService;
import com.netcracker.courses.oe.service.helper.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SimpleCatalogService implements CatalogService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    private final Converter converter;

    @Autowired
    public SimpleCatalogService(ProductRepository productRepository, CategoryRepository categoryRepository, Converter converter) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.converter = converter;
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product product = converter.toProduct(productDTO);
        Category category = categoryRepository.findFirstByName(productDTO.getCategory());
        if (category == null || category.getName().equals(product.getCategory())) {
            Category categorySave = categoryRepository.save(new Category(productDTO.getCategory()));
            product.setCategory(categorySave);
        } else {
            product.setCategory(category);
        }
        Product saveProduct = productRepository.save(product);
        return converter.toProductDTO(saveProduct);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> getAllProducts() {
        List<Product> allProducts = productRepository.findAll();
        List<ProductDTO> productsDTO = converter.toProductsDTO(allProducts);
        return productsDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDTO getProduct(Long id) {
        Product product = productRepository.findOne(id);
        return converter.toProductDTO(product);
    }

    @Override
    public ProductDTO update(ProductDTO productDTO) {
        return save(productDTO);
    }

    @Override
    public void delete(Long id) {
        try {
            productRepository.delete(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }
}
