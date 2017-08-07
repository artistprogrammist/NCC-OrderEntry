package com.netcracker.courses.oe.controller.processor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/processor")
public class ProcessorController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test() {
    }
}
