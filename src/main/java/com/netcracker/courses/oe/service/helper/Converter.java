package com.netcracker.courses.oe.service.helper;

import com.netcracker.courses.oe.dto.catalog.ProductDTO;
import com.netcracker.courses.oe.dto.inventory.InvItemDTO;
import com.netcracker.courses.oe.dto.inventory.InvOrderDTO;
import com.netcracker.courses.oe.dto.processor.ItemDTO;
import com.netcracker.courses.oe.dto.processor.OrderDTO;
import com.netcracker.courses.oe.entity.catalog.Product;
import com.netcracker.courses.oe.entity.inventory.InvItem;
import com.netcracker.courses.oe.entity.inventory.InvOrder;

import java.util.List;

public interface Converter {

    List<ProductDTO> toProductsDTO(List<Product> products);

    Product toProduct(ProductDTO productDTO);

    ProductDTO toProductDTO(Product product);

    List<Product> toProducts(List<ProductDTO> productsDTO);

    InvOrder toInvOrder(InvOrderDTO invOrderDTO);

    InvItem toInvItem(InvItemDTO invItemDTO);

    InvOrderDTO toInvOrderDTO(InvOrder invOrder);

    InvItemDTO toInvItemDTO(InvItem invItem);

    List<InvOrderDTO> toInvOrdersDTO(List<InvOrder> invOrders);

    ItemDTO toItemDTO(ProductDTO productDTO);

    InvOrderDTO toInvOrderDTO(OrderDTO orderDTO);

    OrderDTO toOrderDTO(InvOrderDTO invOrderDTO);
}
