package com.netcracker.courses.oe.service.helper;

import com.netcracker.courses.oe.dto.catalog.ProductDTO;
import com.netcracker.courses.oe.dto.inventory.InvItemDTO;
import com.netcracker.courses.oe.dto.inventory.InvOrderDTO;
import com.netcracker.courses.oe.dto.processor.ItemDTO;
import com.netcracker.courses.oe.dto.processor.OrderDTO;
import com.netcracker.courses.oe.entity.catalog.Category;
import com.netcracker.courses.oe.entity.catalog.Product;
import com.netcracker.courses.oe.entity.inventory.InvItem;
import com.netcracker.courses.oe.entity.inventory.InvOrder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class EntityConverter implements Converter {

    @Override
    public List<ProductDTO> toProductsDTO(List<Product> products) {
        List<ProductDTO> productsDTO = new ArrayList<>();
        if (products != null) {
            products.forEach(product -> {
                productsDTO.add(toProductDTO(product));
            });
        }
        return productsDTO;
    }

    @Override
    public List<Product> toProducts(List<ProductDTO> productsDTO) {
        List<Product> products = new ArrayList<>();
        if (productsDTO != null) {
            productsDTO.forEach(productDTO -> {
                products.add(toProduct(productDTO));
            });
        }
        return products;
    }

    @Override
    public Product toProduct(ProductDTO productDTO) {
        Product product = new Product();
        if (productDTO != null) {
            product.setId(productDTO.getId());
            product.setPrice(productDTO.getPrice());
            product.setBarcode(productDTO.getBarcode());
            product.setName(productDTO.getName());
            product.setProducer(productDTO.getProducer());
            Category category = new Category();
            category.setName(productDTO.getName());
            category.setProducts(Collections.singletonList(product));
            product.setCategory(category);
        }
        return product;
    }

    @Override
    public ProductDTO toProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        if (product != null) {
            productDTO.setId(product.getId());
            productDTO.setPrice(product.getPrice());
            productDTO.setBarcode(product.getBarcode());
            productDTO.setName(product.getName());
            productDTO.setProducer(product.getProducer());
            productDTO.setCategory(product.getCategory().getName());
        }
        return productDTO;
    }

    @Override
    public List<InvOrderDTO> toInvOrdersDTO(List<InvOrder> invOrders) {
        List<InvOrderDTO> invOrdersDTO = new ArrayList<>();
        if (invOrders != null) {
            invOrders.forEach(invOrder -> {
                invOrdersDTO.add(toInvOrderDTO(invOrder));
            });
        }
        return invOrdersDTO;
    }

    @Override
    public InvOrder toInvOrder(InvOrderDTO invOrderDTO) {
        InvOrder invOrder = new InvOrder();
        if (invOrderDTO != null) {
            invOrder.setId(invOrderDTO.getId());
            invOrder.setEmail(invOrderDTO.getEmail());
            invOrder.setGeneralSum(invOrderDTO.getGeneralSum());
            List<InvItem> invItems = new ArrayList<>();
            invOrderDTO.getItems().forEach(itemDTO -> {
                InvItem invItem = toInvItem(itemDTO);
                invItem.setInvOrder(invOrder);
                invItems.add(invItem);
            });
            invOrder.setInvItems(invItems);
        }
        return invOrder;
    }

    @Override
    public InvItem toInvItem(InvItemDTO invItemDTO) {
        InvItem invItem = new InvItem();
        if (invItemDTO != null) {
            invItem.setId(invItemDTO.getId());
            invItem.setName(invItemDTO.getName());
            invItem.setBarcode(invItemDTO.getBarcode());
            invItem.setCategory(invItemDTO.getCategory());
            invItem.setProducer(invItemDTO.getProducer());
            invItem.setPrice(invItemDTO.getPrice());
        }
        return invItem;
    }

    @Override
    public InvOrderDTO toInvOrderDTO(InvOrder invOrder) {
        InvOrderDTO invOrderDTO = new InvOrderDTO();
        if (invOrder != null) {
            invOrderDTO.setId(invOrder.getId());
            invOrderDTO.setEmail(invOrder.getEmail());
            invOrderDTO.setGeneralSum(invOrder.getGeneralSum());
            List<InvItemDTO> itemsDTO = new ArrayList<>();
            invOrder.getInvItems().forEach(invItem -> {
                itemsDTO.add(toInvItemDTO(invItem));
            });
            invOrderDTO.setItems(itemsDTO);
        }
        return invOrderDTO;
    }

    @Override
    public InvItemDTO toInvItemDTO(InvItem invItem) {
        InvItemDTO invItemDTO = new InvItemDTO();
        if (invItem != null) {
            invItemDTO.setId(invItem.getId());
            invItemDTO.setPrice(invItem.getPrice());
            invItemDTO.setName(invItem.getName());
            invItemDTO.setBarcode(invItem.getBarcode());
            invItemDTO.setCategory(invItem.getCategory());
            invItemDTO.setProducer(invItem.getProducer());
        }
        return invItemDTO;
    }

    @Override
    public ItemDTO toItemDTO(ProductDTO productDTO) {
        ItemDTO itemDTO = new ItemDTO();
        if (productDTO != null) {
            itemDTO.setId(productDTO.getId());
            itemDTO.setName(productDTO.getName());
            itemDTO.setBarcode(productDTO.getBarcode());
            itemDTO.setPrice(productDTO.getPrice());
            itemDTO.setCategory(productDTO.getCategory());
            itemDTO.setProducer(productDTO.getProducer());
        }
        return itemDTO;
    }

    @Override
    public InvOrderDTO toInvOrderDTO(OrderDTO orderDTO) {
        InvOrderDTO invOrderDTO = new InvOrderDTO();
        invOrderDTO.setEmail(orderDTO.getEmail());
        invOrderDTO.setGeneralSum(orderDTO.getGeneralSum());
        List<InvItemDTO> invItems = new ArrayList<>();
        orderDTO.getItems().forEach(itemDTO -> {
            InvItemDTO invItemDTO = new InvItemDTO();
            invItemDTO.setId(itemDTO.getId());
            invItemDTO.setPrice(itemDTO.getPrice());
            invItemDTO.setName(itemDTO.getName());
            invItemDTO.setBarcode(itemDTO.getBarcode());
            invItemDTO.setCategory(itemDTO.getCategory());
            invItemDTO.setProducer(itemDTO.getProducer());
            invItems.add(invItemDTO);
        });
        invOrderDTO.setItems(invItems);
        return invOrderDTO;
    }

    @Override
    public OrderDTO toOrderDTO(InvOrderDTO invOrderDTO) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setEmail(invOrderDTO.getEmail());
        orderDTO.setGeneralSum(invOrderDTO.getGeneralSum());
        List<ItemDTO> invItems = new ArrayList<>();
        invOrderDTO.getItems().forEach(invItemDTO -> {
            ItemDTO itemDTO = new ItemDTO();
            itemDTO.setId(invItemDTO.getId());
            itemDTO.setPrice(invItemDTO.getPrice());
            itemDTO.setName(invItemDTO.getName());
            itemDTO.setBarcode(invItemDTO.getBarcode());
            itemDTO.setCategory(invItemDTO.getCategory());
            itemDTO.setProducer(invItemDTO.getProducer());
            invItems.add(itemDTO);
        });
        orderDTO.setItems(invItems);
        return orderDTO;
    }
}
