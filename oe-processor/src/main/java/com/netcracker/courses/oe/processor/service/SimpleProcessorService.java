package com.netcracker.courses.oe.processor.service;

import com.netcracker.courses.oe.processor.dto.catalog.OfferDTO;
import com.netcracker.courses.oe.processor.dto.processor.ItemDTO;
import com.netcracker.courses.oe.processor.dto.processor.ItemOperationParameterDTO;
import com.netcracker.courses.oe.processor.dto.processor.OrderDTO;
import com.netcracker.courses.oe.processor.service.client.CatalogClient;
import com.netcracker.courses.oe.processor.service.client.InventoryClient;
import com.netcracker.courses.oe.processor.service.util.Converter;
import com.netcracker.courses.oe.processor.service.util.TemporaryStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class SimpleProcessorService implements ProcessorService {

    private static final String NOT_PAID = "NOT_PAID";
    private static final String PAID = "PAID";

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
        orderDTO.setDate(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        orderDTO.setOrderNumber(createOrderNumber(email));
        orderDTO.setStatus(NOT_PAID);
        temporaryStorage.save(orderDTO);
        return orderDTO;
    }

    @Override
    public OrderDTO addItem(ItemOperationParameterDTO itemOperationParameterDTO) {
        OfferDTO offerDTO = catalogClient.getOfferDTO(itemOperationParameterDTO.getIdItem());
        OrderDTO orderDTO = temporaryStorage.get(itemOperationParameterDTO.getEmail(), itemOperationParameterDTO.getOrderNumber());
        if (orderDTO != null && offerDTO.getId() != 0) {
            ItemDTO itemDTO = converter.toItemDTO(offerDTO);
            orderDTO.getItems().add(itemDTO);
            orderDTO.setGeneralSum(orderDTO.getGeneralSum() + itemDTO.getPrice());
            orderDTO.setAmount(orderDTO.getItems().size());
        }
        return orderDTO;
    }

    @Override
    public OrderDTO payOrder(String email, String orderNumber) {
        OrderDTO orderDTO = temporaryStorage.get(email, orderNumber);
        if (orderDTO != null) {
            orderDTO.setStatus(PAID);
            OrderDTO save = inventoryClient.save(orderDTO);
            temporaryStorage.deleteOrder(save.getEmail(), orderDTO.getOrderNumber());
            orderDTO = save;
        }
        return orderDTO;
    }

    @Override
    public List<OrderDTO> showAllOrders() {
        return temporaryStorage.getAllOrders();
    }

    @Override
    public List<OrderDTO> showOrdersByStatus(String status) {
        List<OrderDTO> orders = new ArrayList<>();
        switch (status.toUpperCase()) {
            case PAID:
                orders.addAll(inventoryClient.getOrders());
                break;
            case NOT_PAID:
                orders.addAll(showAllOrders());
                break;
            default:
                break;
        }
        return orders;
    }

    @Override
    public List<OrderDTO> showOrdersByEmail(String email) {
        List<OrderDTO> orders = temporaryStorage.get(email);
        orders.addAll(inventoryClient.getOrders(email));
        return orders;
    }

    @Override
    public OrderDTO deleteItem(ItemOperationParameterDTO itemOperationParameterDTO) {
        OrderDTO orderDTO = temporaryStorage.get(itemOperationParameterDTO.getEmail(), itemOperationParameterDTO.getOrderNumber());
        if (orderDTO != null) {
            for (int i = 0; i < orderDTO.getItems().size(); i++) {
                ItemDTO itemDTO = orderDTO.getItems().get(i);
                if (itemDTO.getIdOffer().equals(String.valueOf(itemOperationParameterDTO.getIdItem()))) {
                    orderDTO.getItems().remove(itemDTO);
                    orderDTO.setGeneralSum(orderDTO.getGeneralSum() - itemDTO.getPrice());
                }
            }
            orderDTO.setAmount(orderDTO.getItems().size());
        }
        return orderDTO;
    }

    private String createOrderNumber(String email) {
        LocalDateTime now = LocalDateTime.now();
        long orderNumber = now.hashCode() + email.hashCode();
        return String.valueOf(Math.abs(orderNumber));
    }
}
