package com.netcracker.courses.oe.controller.inventory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/inventory")
public class InventoryController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test() {
    }
}
