package com.netcracker.courses.oe.processor.controller;

import com.netcracker.courses.oe.processor.dto.processor.EntityParameterDTO;
import com.netcracker.courses.oe.processor.dto.processor.OrderDTO;
import com.netcracker.courses.oe.processor.service.ProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/processor")
public class ProcessorController {

    private final ProcessorService processorService;

    @Autowired
    public ProcessorController(ProcessorService processorService) {
        this.processorService = processorService;
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO createOrder(@RequestBody String email) {
        return processorService.createOrder(email);
    }

    @RequestMapping(value = "/item", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO addItem(@RequestBody EntityParameterDTO entityParameterDTO) {
        return processorService.addItem(entityParameterDTO);
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDTO> showAllOrders() {
        return processorService.showAllOrders();
    }

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO pay(@RequestBody String email) {
        return processorService.payOrder(email);
    }
}
