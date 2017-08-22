package com.netcracker.courses.oe.processor.service.util;

import com.netcracker.courses.oe.processor.dto.processor.OrderDTO;

import java.util.List;

public interface TemporaryStorage {

    void save(OrderDTO data);

    OrderDTO get(String email, String orderNumber);

    List<OrderDTO> get(String email);

    void delete(String email);

    OrderDTO deleteOrder(String email, String orderNumber);

    List<OrderDTO> getAllOrders();
}
