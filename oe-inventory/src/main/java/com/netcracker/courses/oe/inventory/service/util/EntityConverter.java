package com.netcracker.courses.oe.inventory.service.util;

import com.netcracker.courses.oe.inventory.dto.ItemDTO;
import com.netcracker.courses.oe.inventory.dto.OrderDTO;
import com.netcracker.courses.oe.inventory.entity.Item;
import com.netcracker.courses.oe.inventory.entity.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class EntityConverter implements Converter {

    private final DateTimeFormatter ISO_LOCAL_DATE_TIME = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @Override
    public List<OrderDTO> toOrdersDTO(List<Order> orders) {
        List<OrderDTO> invOrdersDTO = new ArrayList<>();
        if (orders != null) {
            orders.forEach(invOrder -> {
                invOrdersDTO.add(toOrderDTO(invOrder));
            });
        }
        return invOrdersDTO;
    }

    @Override
    public Order toOrder(OrderDTO orderDTO) {
        Order order = new Order();
        if (orderDTO != null) {
            order.setId(orderDTO.getId());
            order.setEmail(orderDTO.getEmail());
            order.setGeneralSum(orderDTO.getGeneralSum());
            order.setOrderNumber(orderDTO.getOrderNumber());
            order.setStatus(orderDTO.getStatus());
            order.setDate(LocalDateTime.parse(orderDTO.getDate()));
            List<Item> items = new ArrayList<>();
            orderDTO.getItems().forEach(itemDTO -> {
                Item item = toItem(itemDTO);
                item.setOrder(order);
                items.add(item);
            });
            order.setItems(items);
        }
        return order;
    }

    @Override
    public Item toItem(ItemDTO itemDTO) {
        Item item = new Item();
        if (itemDTO != null) {
            item.setId(itemDTO.getId());
            item.setIdOffer(itemDTO.getIdOffer());
            item.setName(itemDTO.getName());
            item.setBarcode(itemDTO.getBarcode());
            item.setCategory(itemDTO.getCategory());
            item.setProducer(itemDTO.getProducer());
            item.setPrice(itemDTO.getPrice());
        }
        return item;
    }

    @Override
    public OrderDTO toOrderDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        if (order != null) {
            orderDTO.setId(order.getId());
            orderDTO.setDate(order.getDate().format(ISO_LOCAL_DATE_TIME));
            orderDTO.setOrderNumber(order.getOrderNumber());
            orderDTO.setAmount(order.getAmount());
            orderDTO.setStatus(order.getStatus());
            orderDTO.setEmail(order.getEmail());
            orderDTO.setGeneralSum(order.getGeneralSum());
            List<ItemDTO> itemsDTO = new ArrayList<>();
            order.getItems().forEach(item -> {
                itemsDTO.add(toItemDTO(item));
            });
            orderDTO.setItems(itemsDTO);
        }
        return orderDTO;
    }

    @Override
    public ItemDTO toItemDTO(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        if (item != null) {
            itemDTO.setId(item.getId());
            itemDTO.setIdOffer(item.getIdOffer());
            itemDTO.setPrice(item.getPrice());
            itemDTO.setName(item.getName());
            itemDTO.setBarcode(item.getBarcode());
            itemDTO.setCategory(item.getCategory());
            itemDTO.setProducer(item.getProducer());
        }
        return itemDTO;
    }
}
