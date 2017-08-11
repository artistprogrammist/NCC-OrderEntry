package com.netcracker.courses.oe.service.client;

import com.netcracker.courses.oe.dto.inventory.InvOrderDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class InventoryClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(InventoryClient.class);
    public static final String API_V1_INVENTORY_ORDERS = "api/v1/inventory/orders";

    private final RestTemplate restTemplate;

    @Value("${url.inventory}")
    private String urlBase;

    @Autowired
    public InventoryClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public InvOrderDTO save(InvOrderDTO invOrderDTO) {
        LOGGER.info("Start method save InvOrderDTO: {}", invOrderDTO);
        StringBuilder finalUrl = new StringBuilder(urlBase);
        finalUrl.append(API_V1_INVENTORY_ORDERS);
        LOGGER.info("FinalUrl: {}", finalUrl.toString());
        ResponseEntity<InvOrderDTO> responseEntity = restTemplate.postForEntity(finalUrl.toString(), invOrderDTO, InvOrderDTO.class);
        LOGGER.info("InvOrderDTO: {}", responseEntity.getBody());
        return responseEntity.getBody();
    }

    private HttpEntity<String> createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        return entity;
    }
}
