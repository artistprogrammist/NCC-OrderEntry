package com.netcracker.courses.oe.service.processor;

import com.netcracker.courses.oe.dto.catalog.ProductDTO;
import com.netcracker.courses.oe.dto.inventory.InvOrderDTO;
import com.netcracker.courses.oe.dto.processor.EntityParameterDTO;
import com.netcracker.courses.oe.dto.processor.ItemDTO;
import com.netcracker.courses.oe.dto.processor.OrderDTO;
import com.netcracker.courses.oe.service.ProcessorService;
import com.netcracker.courses.oe.service.client.CatalogClient;
import com.netcracker.courses.oe.service.client.InventoryClient;
import com.netcracker.courses.oe.service.helper.Converter;
import com.netcracker.courses.oe.service.helper.TemporaryStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleProcessorService implements ProcessorService {

    private final TemporaryStorage temporaryStorage;

    private final CatalogClient catalogClient;

    private final InventoryClient inventoryClient;

    private final Converter converter;

    @Autowired
    public SimpleProcessorService(TemporaryStorage temporaryStorage, CatalogClient catalogClient, InventoryClient inventoryClient, Converter converter) {
        this.temporaryStorage = temporaryStorage;
        this.catalogClient = catalogClient;
        this.inventoryClient = inventoryClient;
        this.converter = converter;
    }

    @Override
    public OrderDTO createOrder(String email) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setEmail(email);
        temporaryStorage.save(orderDTO);
        return orderDTO;
    }

    @Override
    public OrderDTO addItem(EntityParameterDTO entityParameterDTO) {
        ProductDTO productDTO = catalogClient.getProductDTO(entityParameterDTO.getIdItem());
        OrderDTO orderDTO = temporaryStorage.get(entityParameterDTO.getEmail());
        if (orderDTO != null && productDTO.getId() != 0) {
            ItemDTO itemDTO = converter.toItemDTO(productDTO);
            orderDTO.getItems().add(itemDTO);
            orderDTO.setGeneralSum(orderDTO.getGeneralSum() + itemDTO.getPrice());
        }
        return orderDTO;
    }

    @Override
    public OrderDTO payOrder(String email) {
        OrderDTO orderDTO = temporaryStorage.get(email);
        if (orderDTO != null) {
            InvOrderDTO invOrderDTO = converter.toInvOrderDTO(orderDTO);
            InvOrderDTO save = inventoryClient.save(invOrderDTO);
            temporaryStorage.delete(save.getEmail());
            orderDTO = converter.toOrderDTO(save);
        }
        return orderDTO;
    }

    @Override
    public List<OrderDTO> showAllOrders() {
        return temporaryStorage.getAllOrders();
    }
}
