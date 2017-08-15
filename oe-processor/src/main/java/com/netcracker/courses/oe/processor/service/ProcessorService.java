package com.netcracker.courses.oe.processor.service;

import com.netcracker.courses.oe.processor.dto.processor.EntityParameterDTO;
import com.netcracker.courses.oe.processor.dto.processor.OrderDTO;

import java.util.List;

public interface ProcessorService {
    OrderDTO createOrder(String email);

    OrderDTO addItem(EntityParameterDTO entityParameterDTO);

    OrderDTO payOrder(String email);

    List<OrderDTO> showAllOrders();
}
