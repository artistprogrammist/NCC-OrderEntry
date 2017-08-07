package com.netcracker.courses.oe.controller.catalog;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/catalog")
public class CatalogController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test() {
    }
}
