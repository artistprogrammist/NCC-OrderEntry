package com.netcracker.courses.oe.inventory.service;

import com.netcracker.courses.oe.inventory.dto.OrderDTO;
import com.netcracker.courses.oe.inventory.entity.Order;
import com.netcracker.courses.oe.inventory.exception.EntityNotFoundException;
import com.netcracker.courses.oe.inventory.repository.InventoryRepository;
import com.netcracker.courses.oe.inventory.service.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleInventoryService implements InventoryService {

    private final InventoryRepository inventoryRepository;

    private final Converter converter;

    @Autowired
    public SimpleInventoryService(InventoryRepository inventoryRepository, Converter converter) {
        this.inventoryRepository = inventoryRepository;
        this.converter = converter;
    }

    @Override
    public OrderDTO save(OrderDTO orderDTO) {
        Order order = converter.toOrder(orderDTO);
        Order saveOrder = inventoryRepository.save(order);
        return converter.toOrderDTO(saveOrder);
    }

    @Override
    public OrderDTO update(OrderDTO orderDTO) {
        return save(orderDTO);
    }

    @Override
    public List<OrderDTO> getAllInvOrders() {
        List<Order> allOrder = inventoryRepository.findAll();
        return converter.toOrdersDTO(allOrder);
    }

    @Override
    public OrderDTO getInvOrder(Long id) {
        Order oneOrder = inventoryRepository.findOne(id);
        return converter.toOrderDTO(oneOrder);
    }

    @Override
    public void delete(Long id) {
        try {
            inventoryRepository.delete(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(e.getMessage(), e);
        }
    }
}
