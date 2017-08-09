package com.netcracker.courses.oe.service;

import com.netcracker.courses.oe.dto.catalog.ProductDTO;

import java.util.List;

public interface CatalogService {

    ProductDTO save(ProductDTO productDTO);

    List<ProductDTO> getAllProducts();

    ProductDTO getProduct(Long id);

    ProductDTO update(ProductDTO productDTO);

    void delete(Long id);
}
