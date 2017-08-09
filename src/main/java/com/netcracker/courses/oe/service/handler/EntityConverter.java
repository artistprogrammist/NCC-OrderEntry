package com.netcracker.courses.oe.service.handler;

import com.netcracker.courses.oe.dto.catalog.PriceDTO;
import com.netcracker.courses.oe.dto.catalog.ProductDTO;
import com.netcracker.courses.oe.dto.inventory.InvOrderDTO;
import com.netcracker.courses.oe.dto.inventory.ItemDTO;
import com.netcracker.courses.oe.entity.catalog.Category;
import com.netcracker.courses.oe.entity.catalog.Price;
import com.netcracker.courses.oe.entity.catalog.Product;
import com.netcracker.courses.oe.entity.inventory.InvOrder;
import com.netcracker.courses.oe.entity.inventory.Item;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class EntityConverter implements Converter {

    @Override
    public List<ProductDTO> toProductsDTO(List<Product> products) {
        List<ProductDTO> productsDTO = new ArrayList<>();
        products.forEach(product -> {
            productsDTO.add(toProductDTO(product));
        });
        return productsDTO;
    }

    @Override
    public List<Product> toProducts(List<ProductDTO> productsDTO) {
        List<Product> products = new ArrayList<>();
        productsDTO.forEach(productDTO -> {
            products.add(toProduct(productDTO));
        });
        return products;
    }

    @Override
    public Product toProduct(ProductDTO productDTO) {
        Product product = new Product();
        List<Price> prices = new ArrayList<>();
        product.setId(productDTO.getId());
        product.setQuantity(productDTO.getQuantity());
        product.setBarcode(productDTO.getBarcode());
        product.setName(productDTO.getName());
        product.setProducer(productDTO.getProducer());
        Category category = new Category();
        category.setName(productDTO.getName());
        category.setProducts(Collections.singletonList(product));
        product.setCategory(category);
        productDTO.getPrices().forEach(priceDTO -> {
            Price price = new Price();
            price.setCurrency(priceDTO.getCurrency());
            price.setCurrencyValue(priceDTO.getCurrencyValue());
            price.setProduct(product);
            prices.add(price);
        });
        product.setPrice(prices);
        return product;
    }

    @Override
    public ProductDTO toProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setBarcode(product.getBarcode());
        productDTO.setName(product.getName());
        productDTO.setProducer(product.getProducer());
        List<PriceDTO> pricesDTO = new ArrayList<>();
        product.getPrice().forEach(price -> {
            PriceDTO priceDTO = new PriceDTO();
            priceDTO.setCurrency(price.getCurrency());
            priceDTO.setCurrencyValue(price.getCurrencyValue());
            pricesDTO.add(priceDTO);
        });
        productDTO.setPrices(pricesDTO);
        productDTO.setCategory(product.getCategory().getName());
        return productDTO;
    }

    @Override
    public List<InvOrderDTO> toInvOrdersDTO(List<InvOrder> invOrders) {
        List<InvOrderDTO> invOrdersDTO = new ArrayList<>();
        invOrders.forEach(invOrder -> {
            invOrdersDTO.add(toInvOrderDTO(invOrder));
        });
        return invOrdersDTO;
    }

    @Override
    public InvOrder toInvOrder(InvOrderDTO invOrderDTO) {
        InvOrder invOrder = new InvOrder();
        invOrder.setId(invOrderDTO.getId());
        invOrder.setEmail(invOrderDTO.getEmail());
        invOrder.setGeneralSum(invOrderDTO.getGeneralSum());
        List<Item> items = new ArrayList<>();
        invOrderDTO.getItems().forEach(itemDTO -> {
            Item item = toItem(itemDTO);
            item.setInvOrder(invOrder);
            items.add(item);
        });
        invOrder.setItems(items);
        return invOrder;
    }

    @Override
    public InvOrderDTO toInvOrderDTO(InvOrder invOrder) {
        InvOrderDTO invOrderDTO = new InvOrderDTO();
        invOrderDTO.setId(invOrder.getId());
        invOrderDTO.setEmail(invOrder.getEmail());
        invOrderDTO.setGeneralSum(invOrder.getGeneralSum());
        List<ItemDTO> itemsDTO = new ArrayList<>();
        invOrder.getItems().forEach(item -> {
            itemsDTO.add(toItemDTO(item));
        });
        invOrderDTO.setItems(itemsDTO);
        return invOrderDTO;
    }

    @Override
    public ItemDTO toItemDTO(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(item.getId());
        itemDTO.setName(item.getName());
        itemDTO.setBarcode(item.getBarcode());
        itemDTO.setCategory(item.getCategory());
        itemDTO.setCurrency(item.getCurrency());
        itemDTO.setCurrencyValue(item.getCurrencyValue());
        itemDTO.setProducer(item.getProducer());
        itemDTO.setQuantity(item.getQuantity());
        return itemDTO;
    }

    @Override
    public Item toItem(ItemDTO itemDTO) {
        Item item = new Item();
        item.setId(itemDTO.getId());
        item.setName(itemDTO.getName());
        item.setBarcode(itemDTO.getBarcode());
        item.setCategory(itemDTO.getCategory());
        item.setCurrency(itemDTO.getCurrency());
        item.setCurrencyValue(itemDTO.getCurrencyValue());
        item.setProducer(itemDTO.getProducer());
        item.setQuantity(itemDTO.getQuantity());
        return item;
    }
}
