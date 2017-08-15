package com.netcracker.courses.oe.processor.service.helper;

import com.netcracker.courses.oe.processor.dto.catalog.ProductDTO;
import com.netcracker.courses.oe.processor.dto.inventory.InvOrderDTO;
import com.netcracker.courses.oe.processor.dto.processor.ItemDTO;
import com.netcracker.courses.oe.processor.dto.processor.OrderDTO;

public interface Converter {

    ItemDTO toItemDTO(ProductDTO productDTO);

    InvOrderDTO toInvOrderDTO(OrderDTO orderDTO);

    OrderDTO toOrderDTO(InvOrderDTO invOrderDTO);
}
