package com.netcracker.courses.oe.processor.service;

import com.netcracker.courses.oe.processor.dto.processor.ItemOperationParameterDTO;
import com.netcracker.courses.oe.processor.dto.processor.OrderDTO;

import java.util.List;

public interface ProcessorService {
    OrderDTO createOrder(String email);

    OrderDTO addItem(ItemOperationParameterDTO itemOperationParameterDTO);

    OrderDTO payOrder(String email, String orderNumber);

    List<OrderDTO> showAllOrders();

    List<OrderDTO> showOrdersByStatus(String status);

    List<OrderDTO> showOrdersByEmail(String email);

    OrderDTO deleteItem(ItemOperationParameterDTO itemOperationParameterDTO);
}
