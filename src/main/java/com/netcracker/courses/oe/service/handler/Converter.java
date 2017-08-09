package com.netcracker.courses.oe.service.handler;

import com.netcracker.courses.oe.dto.catalog.ProductDTO;
import com.netcracker.courses.oe.dto.inventory.InvOrderDTO;
import com.netcracker.courses.oe.dto.inventory.ItemDTO;
import com.netcracker.courses.oe.entity.catalog.Product;
import com.netcracker.courses.oe.entity.inventory.InvOrder;
import com.netcracker.courses.oe.entity.inventory.Item;

import java.util.List;

public interface Converter {

    List<ProductDTO> toProductsDTO(List<Product> products);

    Product toProduct(ProductDTO productDTO);

    ProductDTO toProductDTO(Product product);

    List<Product> toProducts(List<ProductDTO> productsDTO);

    InvOrder toInvOrder(InvOrderDTO invOrderDTO);

    Item toItem(ItemDTO itemDTO);

    InvOrderDTO toInvOrderDTO(InvOrder invOrder);

    ItemDTO toItemDTO(Item item);

    List<InvOrderDTO> toInvOrdersDTO(List<InvOrder> invOrders);
}
