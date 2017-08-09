package com.netcracker.courses.oe.service;

import com.netcracker.courses.oe.dto.inventory.InvOrderDTO;

import java.util.List;

public interface InventoryService {

    InvOrderDTO save(InvOrderDTO invOrderDTO);

    InvOrderDTO update(InvOrderDTO invOrderDTO);

    List<InvOrderDTO> getAllInvOrders();

    InvOrderDTO getInvOrder(Long id);

    void delete(Long id);
}
