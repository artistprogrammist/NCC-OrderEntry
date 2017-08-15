package com.netcracker.courses.oe.processor.service.client;

import com.netcracker.courses.oe.processor.dto.catalog.OfferDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class CatalogClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogClient.class);
    private static final String API_V1_CATALOG_PRODUCTS = "/api/v1/catalog/products/";

    private final RestTemplate restTemplate;

    @Value("${url.catalog}")
    private String urlBase;

    @Autowired
    public CatalogClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public OfferDTO getOfferDTO(Long id) {
        LOGGER.info("Start method getProductDTO Id = {}", id);
        StringBuilder finalUrl = new StringBuilder(urlBase);
        finalUrl.append(API_V1_CATALOG_PRODUCTS);
        finalUrl.append(id);
        LOGGER.info("FinalUrl: {}", finalUrl.toString());
        ResponseEntity<OfferDTO> responseEntity = restTemplate.exchange(finalUrl.toString(), HttpMethod.GET, createHeaders(), OfferDTO.class);
        LOGGER.info("OfferDTO: {}", responseEntity.getBody());
        return responseEntity.getBody();
    }

    private HttpEntity<String> createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        return entity;
    }
}
