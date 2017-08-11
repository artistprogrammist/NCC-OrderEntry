package com.netcracker.courses.oe.service.helper;

import com.netcracker.courses.oe.dto.processor.OrderDTO;

import java.util.List;

public interface TemporaryStorage {

    void save(OrderDTO data);

    OrderDTO get(String key);

    OrderDTO delete(String key);

    List<OrderDTO> getAllOrders();
}
