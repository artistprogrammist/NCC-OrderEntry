package com.netcracker.courses.oe.inventory.service.helper;


import com.netcracker.courses.oe.inventory.dto.InvItemDTO;
import com.netcracker.courses.oe.inventory.dto.InvOrderDTO;
import com.netcracker.courses.oe.inventory.entity.InvItem;
import com.netcracker.courses.oe.inventory.entity.InvOrder;

import java.util.List;

public interface Converter {
    InvOrder toInvOrder(InvOrderDTO invOrderDTO);

    InvItem toInvItem(InvItemDTO invItemDTO);

    InvOrderDTO toInvOrderDTO(InvOrder invOrder);

    InvItemDTO toInvItemDTO(InvItem invItem);

    List<InvOrderDTO> toInvOrdersDTO(List<InvOrder> invOrders);
}
