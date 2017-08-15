package com.netcracker.courses.oe.catalog.controller;

import com.netcracker.courses.oe.catalog.exception.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@ControllerAdvice(annotations = RestController.class)
public class GlobalControllerExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    private String handleEntityNotFoundException(EntityNotFoundException exception) {
        StringBuilder message = new StringBuilder("Error: ");
        message.append(exception.getMessage());
        LOGGER.error("Error : ", exception);
        return message.toString();
    }

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
