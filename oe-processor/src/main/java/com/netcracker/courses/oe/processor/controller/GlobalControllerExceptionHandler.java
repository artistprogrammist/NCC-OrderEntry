package com.netcracker.courses.oe.processor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice(annotations = RestController.class)
public class GlobalControllerExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    private String handleException(Exception exception) {
        StringBuilder message = new StringBuilder("Error: ");
        message.append(exception.getMessage());
        LOGGER.error("Error: ", exception);
        return message.toString();
    }
}
