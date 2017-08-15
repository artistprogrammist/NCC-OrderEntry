package com.netcracker.courses.oe.processor.service.helper;

import com.netcracker.courses.oe.processor.dto.catalog.ProductDTO;
import com.netcracker.courses.oe.processor.dto.inventory.InvItemDTO;
import com.netcracker.courses.oe.processor.dto.inventory.InvOrderDTO;
import com.netcracker.courses.oe.processor.dto.processor.ItemDTO;
import com.netcracker.courses.oe.processor.dto.processor.OrderDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EntityConverter implements Converter {

    @Override
    public ItemDTO toItemDTO(ProductDTO productDTO) {
        ItemDTO itemDTO = new ItemDTO();
        if (productDTO != null) {
            itemDTO.setId(productDTO.getId());
            itemDTO.setName(productDTO.getName());
            itemDTO.setBarcode(productDTO.getBarcode());
            itemDTO.setPrice(productDTO.getPrice());
            itemDTO.setCategory(productDTO.getCategory());
            itemDTO.setProducer(productDTO.getProducer());
        }
        return itemDTO;
    }

    @Override
    public InvOrderDTO toInvOrderDTO(OrderDTO orderDTO) {
        InvOrderDTO invOrderDTO = new InvOrderDTO();
        invOrderDTO.setEmail(orderDTO.getEmail());
        invOrderDTO.setGeneralSum(orderDTO.getGeneralSum());
        List<InvItemDTO> invItems = new ArrayList<>();
        orderDTO.getItems().forEach(itemDTO -> {
            InvItemDTO invItemDTO = new InvItemDTO();
            invItemDTO.setId(itemDTO.getId());
            invItemDTO.setPrice(itemDTO.getPrice());
            invItemDTO.setName(itemDTO.getName());
            invItemDTO.setBarcode(itemDTO.getBarcode());
            invItemDTO.setCategory(itemDTO.getCategory());
            invItemDTO.setProducer(itemDTO.getProducer());
            invItems.add(invItemDTO);
        });
        invOrderDTO.setItems(invItems);
        return invOrderDTO;
    }

    @Override
    public OrderDTO toOrderDTO(InvOrderDTO invOrderDTO) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setEmail(invOrderDTO.getEmail());
        orderDTO.setGeneralSum(invOrderDTO.getGeneralSum());
        List<ItemDTO> invItems = new ArrayList<>();
        invOrderDTO.getItems().forEach(invItemDTO -> {
            ItemDTO itemDTO = new ItemDTO();
            itemDTO.setId(invItemDTO.getId());
            itemDTO.setPrice(invItemDTO.getPrice());
            itemDTO.setName(invItemDTO.getName());
            itemDTO.setBarcode(invItemDTO.getBarcode());
            itemDTO.setCategory(invItemDTO.getCategory());
            itemDTO.setProducer(invItemDTO.getProducer());
            invItems.add(itemDTO);
        });
        orderDTO.setItems(invItems);
        return orderDTO;
    }
}