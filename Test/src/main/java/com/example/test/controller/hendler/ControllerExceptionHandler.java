package com.example.test.controller.hendler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<ExceptionMessage> constraintException(ConstraintViolationException exception,
                                                                      WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ExceptionMessage.builder()
                        .message(exception.getMessage())
                        .exceptionName(exception.getClass().getSimpleName())
                        .endpoint(((ServletWebRequest) request).getRequest().getRequestURI())
                        .build());
    }
}
