package com.netcracker.courses.oe.inventory.service.helper;

import com.netcracker.courses.oe.inventory.dto.InvItemDTO;
import com.netcracker.courses.oe.inventory.dto.InvOrderDTO;
import com.netcracker.courses.oe.inventory.entity.InvItem;
import com.netcracker.courses.oe.inventory.entity.InvOrder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EntityConverter implements Converter {

    @Override
    public List<InvOrderDTO> toInvOrdersDTO(List<InvOrder> invOrders) {
        List<InvOrderDTO> invOrdersDTO = new ArrayList<>();
        if (invOrders != null) {
            invOrders.forEach(invOrder -> {
                invOrdersDTO.add(toInvOrderDTO(invOrder));
            });
        }
        return invOrdersDTO;
    }

    @Override
    public InvOrder toInvOrder(InvOrderDTO invOrderDTO) {
        InvOrder invOrder = new InvOrder();
        if (invOrderDTO != null) {
            invOrder.setId(invOrderDTO.getId());
            invOrder.setEmail(invOrderDTO.getEmail());
            invOrder.setGeneralSum(invOrderDTO.getGeneralSum());
            List<InvItem> invItems = new ArrayList<>();
            invOrderDTO.getItems().forEach(itemDTO -> {
                InvItem invItem = toInvItem(itemDTO);
                invItem.setInvOrder(invOrder);
                invItems.add(invItem);
            });
            invOrder.setInvItems(invItems);
        }
        return invOrder;
    }

    @Override
    public InvItem toInvItem(InvItemDTO invItemDTO) {
        InvItem invItem = new InvItem();
        if (invItemDTO != null) {
            invItem.setId(invItemDTO.getId());
            invItem.setName(invItemDTO.getName());
            invItem.setBarcode(invItemDTO.getBarcode());
            invItem.setCategory(invItemDTO.getCategory());
            invItem.setProducer(invItemDTO.getProducer());
            invItem.setPrice(invItemDTO.getPrice());
        }
        return invItem;
    }

    @Override
    public InvOrderDTO toInvOrderDTO(InvOrder invOrder) {
        InvOrderDTO invOrderDTO = new InvOrderDTO();
        if (invOrder != null) {
            invOrderDTO.setId(invOrder.getId());
            invOrderDTO.setEmail(invOrder.getEmail());
            invOrderDTO.setGeneralSum(invOrder.getGeneralSum());
            List<InvItemDTO> itemsDTO = new ArrayList<>();
            invOrder.getInvItems().forEach(invItem -> {
                itemsDTO.add(toInvItemDTO(invItem));
            });
            invOrderDTO.setItems(itemsDTO);
        }
        return invOrderDTO;
    }

    @Override
    public InvItemDTO toInvItemDTO(InvItem invItem) {
        InvItemDTO invItemDTO = new InvItemDTO();
        if (invItem != null) {
            invItemDTO.setId(invItem.getId());
            invItemDTO.setPrice(invItem.getPrice());
            invItemDTO.setName(invItem.getName());
            invItemDTO.setBarcode(invItem.getBarcode());
            invItemDTO.setCategory(invItem.getCategory());
            invItemDTO.setProducer(invItem.getProducer());
        }
        return invItemDTO;
    }
}
