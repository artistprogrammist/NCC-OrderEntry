package com.netcracker.courses.oe.processor.controller;

import com.netcracker.courses.oe.processor.dto.processor.ItemOperationParameterDTO;
import com.netcracker.courses.oe.processor.dto.processor.OrderDTO;
import com.netcracker.courses.oe.processor.dto.processor.PayParameterDTO;
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
    public OrderDTO addItem(@RequestBody ItemOperationParameterDTO itemOperationParameterDTO) {
        return processorService.addItem(itemOperationParameterDTO);
    }

    @RequestMapping(value = "/orders/status/{status}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDTO> showOrdersByStatus(@PathVariable("status") String status) {
        return processorService.showOrdersByStatus(status);
    }

    @RequestMapping(value = "/orders/email/{email}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDTO> showOrdersByEmail(@PathVariable("email") String email) {
        return processorService.showOrdersByEmail(email);
    }

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO pay(@RequestBody PayParameterDTO payParameter) {
        return processorService.payOrder(payParameter.getEmail(), payParameter.getOrderNumber());
    }

    @RequestMapping(value = "/item", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public OrderDTO deleteItem(@RequestBody ItemOperationParameterDTO itemOperationParameterDTO) {
        return processorService.deleteItem(itemOperationParameterDTO);
    }
}
