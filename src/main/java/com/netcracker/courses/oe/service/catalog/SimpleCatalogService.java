package com.netcracker.courses.oe.service.catalog;

import com.netcracker.courses.oe.dto.catalog.ProductDTO;
import com.netcracker.courses.oe.entity.catalog.Product;
import com.netcracker.courses.oe.exception.EntityNotFoundException;
import com.netcracker.courses.oe.repository.catalog.CatalogRepository;
import com.netcracker.courses.oe.service.CatalogService;
import com.netcracker.courses.oe.service.handler.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SimpleCatalogService implements CatalogService {

    private final CatalogRepository catalogRepository;

    private final Converter converter;

    @Autowired
    public SimpleCatalogService(CatalogRepository catalogRepository, Converter converter) {
        this.catalogRepository = catalogRepository;
        this.converter = converter;
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product product = converter.toProduct(productDTO);
        Product saveProduct = catalogRepository.save(product);
        return converter.toProductDTO(saveProduct);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> getAllProducts() {
        List<Product> allProducts = catalogRepository.findAll();
        List<ProductDTO> productsDTO = converter.toProductsDTO(allProducts);
        return productsDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDTO getProduct(Long id) {
        Product product = catalogRepository.findOne(id);
        return converter.toProductDTO(product);
    }

    @Override
    public ProductDTO update(ProductDTO productDTO) {
        Product product = converter.toProduct(productDTO);
        Product saveProduct = catalogRepository.save(product);
        return converter.toProductDTO(saveProduct);
    }

    @Override
    public void delete(Long id) {
        try {
            catalogRepository.delete(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }
}
