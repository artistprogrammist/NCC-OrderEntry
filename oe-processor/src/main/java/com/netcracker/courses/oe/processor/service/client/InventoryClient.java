package com.netcracker.courses.oe.processor.service.client;

import com.netcracker.courses.oe.processor.dto.processor.OrderDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class InventoryClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(InventoryClient.class);
    private static final String API_V1_INVENTORY_ORDERS = "api/v1/inventory/orders";
    private static final String API_V1_INVENTORY_ORDERS_EMAIL = "/api/v1/inventory/orders/email/{email}";

    private final RestTemplate restTemplate;

    @Value("${url.inventory}")
    private String urlBase;

    @Autowired
    public InventoryClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public OrderDTO save(OrderDTO orderDTO) {
        LOGGER.info("Start method save InvOrderDTO: {}", orderDTO);
        StringBuilder finalUrl = new StringBuilder(urlBase);
        finalUrl.append(API_V1_INVENTORY_ORDERS);
        LOGGER.info("FinalUrl: {}", finalUrl.toString());
        ResponseEntity<OrderDTO> responseEntity = restTemplate.postForEntity(finalUrl.toString(), orderDTO, OrderDTO.class);
        LOGGER.info("OrderDTO: {}", responseEntity.getBody());
        return responseEntity.getBody();
    }

    public List<OrderDTO> getOrders(String email) {
        LOGGER.info("Start method save getOrders");
        StringBuilder finalUrl = new StringBuilder(urlBase);
        finalUrl.append(API_V1_INVENTORY_ORDERS_EMAIL);
        LOGGER.info("FinalUrl: {}", finalUrl.toString());
        ResponseEntity<OrderDTO[]> responseEntity = restTemplate.getForEntity(finalUrl.toString(), OrderDTO[].class, email);
        LOGGER.info("Size OrdersDTO: {}", responseEntity.getBody().length);
        return Arrays.asList(responseEntity.getBody());
    }

    public List<OrderDTO> getOrders() {
        LOGGER.info("Start method save getOrders");
        StringBuilder finalUrl = new StringBuilder(urlBase);
        finalUrl.append(API_V1_INVENTORY_ORDERS);
        LOGGER.info("FinalUrl: {}", finalUrl.toString());
        ResponseEntity<OrderDTO[]> responseEntity = restTemplate.exchange(finalUrl.toString(), HttpMethod.GET, createHeaders(), OrderDTO[].class);
        LOGGER.info("Size OrdersDTO: {}", responseEntity.getBody().length);
        return Arrays.asList(responseEntity.getBody());
    }

    private HttpEntity<String> createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        return entity;
    }
}
