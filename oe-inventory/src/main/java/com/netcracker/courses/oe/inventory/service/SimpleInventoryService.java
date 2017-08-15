package com.netcracker.courses.oe.inventory.service;


import com.netcracker.courses.oe.inventory.dto.InvOrderDTO;
import com.netcracker.courses.oe.inventory.entity.InvOrder;
import com.netcracker.courses.oe.inventory.exception.EntityNotFoundException;
import com.netcracker.courses.oe.inventory.repository.InventoryRepository;
import com.netcracker.courses.oe.inventory.service.InventoryService;
import com.netcracker.courses.oe.inventory.service.helper.Converter;
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
    public InvOrderDTO save(InvOrderDTO invOrderDTO) {
        InvOrder invOrder = converter.toInvOrder(invOrderDTO);
        InvOrder saveInvOrder = inventoryRepository.save(invOrder);
        return converter.toInvOrderDTO(saveInvOrder);
    }

    @Override
    public InvOrderDTO update(InvOrderDTO invOrderDTO) {
        return save(invOrderDTO);
    }

    @Override
    public List<InvOrderDTO> getAllInvOrders() {
        List<InvOrder> allInvOrder = inventoryRepository.findAll();
        return converter.toInvOrdersDTO(allInvOrder);
    }

    @Override
    public InvOrderDTO getInvOrder(Long id) {
        InvOrder oneInvOrder = inventoryRepository.findOne(id);
        return converter.toInvOrderDTO(oneInvOrder);
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
