package com.netcracker.courses.oe.controller;

import com.netcracker.courses.oe.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice(annotations = RestController.class)
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    private String handleEntityNotFoundException(EntityNotFoundException exception) {
        StringBuilder message = new StringBuilder("Error: ");
        message.append(exception.getMessage());
        return message.toString();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    private String handleException(Exception exception) {
        StringBuilder message = new StringBuilder("Error: ");
        message.append(exception.getMessage());
        return message.toString();
    }
}
