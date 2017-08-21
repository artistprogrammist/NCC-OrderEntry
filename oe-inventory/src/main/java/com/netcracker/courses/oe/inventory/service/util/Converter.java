package com.netcracker.courses.oe.inventory.service.util;

import com.netcracker.courses.oe.inventory.dto.ItemDTO;
import com.netcracker.courses.oe.inventory.dto.OrderDTO;
import com.netcracker.courses.oe.inventory.entity.Item;
import com.netcracker.courses.oe.inventory.entity.Order;

import java.util.List;

public interface Converter {
    Order toOrder(OrderDTO orderDTO);

    Item toItem(ItemDTO itemDTO);

    OrderDTO toOrderDTO(Order order);

    ItemDTO toItemDTO(Item item);

    List<OrderDTO> toOrdersDTO(List<Order> orders);
}
