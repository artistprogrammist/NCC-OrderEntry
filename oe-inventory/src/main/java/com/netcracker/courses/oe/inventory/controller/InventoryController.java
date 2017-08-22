package com.netcracker.courses.oe.inventory.controller;

import com.netcracker.courses.oe.inventory.dto.OrderDTO;
import com.netcracker.courses.oe.inventory.service.InventoryService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/inventory/orders")
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO saveOrder(@ApiParam(name = "date", value = "Example date: 2007-12-03T10:15:30") @RequestBody OrderDTO orderDTO) {
        return inventoryService.save(orderDTO);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO updateOrder(@RequestBody OrderDTO orderDTO) {
        return inventoryService.update(orderDTO);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDTO> getAllOrders() {
        return inventoryService.getAllOrders();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public OrderDTO getOrder(@PathVariable("id") Long id) {
        return inventoryService.getOrder(id);
    }

    @RequestMapping(value = "/email/{email}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDTO> getOrders(@PathVariable("email") String email) {
        return inventoryService.getOrders(email);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("id") Long id) {
        inventoryService.delete(id);
    }
}
