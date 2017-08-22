package com.netcracker.courses.oe.processor.service.util;

import com.netcracker.courses.oe.processor.dto.catalog.OfferDTO;
import com.netcracker.courses.oe.processor.dto.processor.ItemDTO;
import org.springframework.stereotype.Component;

@Component
public class EntityConverter implements Converter {

    @Override
    public ItemDTO toItemDTO(OfferDTO offerDTO) {
        ItemDTO itemDTO = new ItemDTO();
        if (offerDTO != null) {
            itemDTO.setIdOffer(String.valueOf(offerDTO.getId()));
            itemDTO.setName(offerDTO.getName());
            itemDTO.setBarcode(offerDTO.getBarcode());
            itemDTO.setPrice(offerDTO.getPrice());
            itemDTO.setCategory(offerDTO.getCategory());
            itemDTO.setProducer(offerDTO.getProducer());
        }
        return itemDTO;
    }
//
//    @Override
//    public OrderDTO toInvOrderDTO(OrderDTO orderDTO) {
//        InvOrderDTO invOrderDTO = new InvOrderDTO();
//        invOrderDTO.setEmail(orderDTO.getEmail());
//        invOrderDTO.setGeneralSum(orderDTO.getGeneralSum());
//        List<InvItemDTO> invItems = new ArrayList<>();
//        orderDTO.getItems().forEach(itemDTO -> {
//            InvItemDTO invItemDTO = new InvItemDTO();
//            invItemDTO.setId(itemDTO.getId());
//            invItemDTO.setPrice(itemDTO.getPrice());
//            invItemDTO.setName(itemDTO.getName());
//            invItemDTO.setBarcode(itemDTO.getBarcode());
//            invItemDTO.setCategory(itemDTO.getCategory());
//            invItemDTO.setProducer(itemDTO.getProducer());
//            invItems.add(invItemDTO);
//        });
//        invOrderDTO.setItems(invItems);
//        return invOrderDTO;
//    }

//    @Override
//    public OrderDTO toOrderDTO(InvOrderDTO invOrderDTO) {
//        OrderDTO orderDTO = new OrderDTO();
//        orderDTO.setEmail(invOrderDTO.getEmail());
//        orderDTO.setGeneralSum(invOrderDTO.getGeneralSum());
//        List<ItemDTO> invItems = new ArrayList<>();
//        invOrderDTO.getItems().forEach(invItemDTO -> {
//            ItemDTO itemDTO = new ItemDTO();
//            itemDTO.setId(invItemDTO.getId());
//            itemDTO.setPrice(invItemDTO.getPrice());
//            itemDTO.setName(invItemDTO.getName());
//            itemDTO.setBarcode(invItemDTO.getBarcode());
//            itemDTO.setCategory(invItemDTO.getCategory());
//            itemDTO.setProducer(invItemDTO.getProducer());
//            invItems.add(itemDTO);
//        });
//        orderDTO.setItems(invItems);
//        return orderDTO;
//    }
}
