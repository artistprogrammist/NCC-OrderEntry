package com.netcracker.courses.oe.inventory.service;

import com.netcracker.courses.oe.inventory.dto.OrderDTO;

import java.util.List;

public interface InventoryService {

    OrderDTO save(OrderDTO orderDTO);

    OrderDTO update(OrderDTO orderDTO);

    List<OrderDTO> getAllOrders();

    List<OrderDTO> getOrders(String email);

    OrderDTO getOrder(Long id);

    void delete(Long id);
}
