package com.netcracker.courses.oe.processor.service.helper;

import com.netcracker.courses.oe.processor.dto.processor.OrderDTO;

import java.util.List;

public interface TemporaryStorage {

    void save(OrderDTO data);

    OrderDTO get(String key);

    OrderDTO delete(String key);

    List<OrderDTO> getAllOrders();
}
