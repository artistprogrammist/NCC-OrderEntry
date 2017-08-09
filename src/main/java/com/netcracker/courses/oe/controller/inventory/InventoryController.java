package com.netcracker.courses.oe.controller.inventory;

import com.netcracker.courses.oe.dto.catalog.ProductDTO;
import com.netcracker.courses.oe.dto.inventory.InvOrderDTO;
import com.netcracker.courses.oe.entity.inventory.InvOrder;
import com.netcracker.courses.oe.service.CatalogService;
import com.netcracker.courses.oe.service.InventoryService;
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
    public InvOrderDTO saveInvOrder(@RequestBody InvOrderDTO invOrderDTO) {
        return inventoryService.save(invOrderDTO);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public InvOrderDTO updateInvOrder(@RequestBody InvOrderDTO invOrderDTO) {
        return inventoryService.update(invOrderDTO);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<InvOrderDTO> getAllInvOrders() {
        return inventoryService.getAllInvOrders();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public InvOrderDTO getInvOrder(@PathVariable("id") Long id) {
        return inventoryService.getInvOrder(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInvOrder(@PathVariable("id") Long id) {
        inventoryService.delete(id);
    }
}
