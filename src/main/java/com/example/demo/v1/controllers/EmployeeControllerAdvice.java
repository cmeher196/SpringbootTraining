package com.example.demo.v1.controllers;


import com.example.demo.v1.exceptions.EmployeeNotFoundException;
import com.example.demo.v1.exceptions.ProductNotFoundException;
import com.example.demo.v1.model.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeControllerAdvice {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<String> employeeNotFoundExpection(EmployeeNotFoundException ex){
        ExceptionDTO exceptionDTO = new ExceptionDTO(
                ex.getMessage(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(exceptionDTO.getMessage(), exceptionDTO.getHttpStatus());
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> productNotFoundExpection(EmployeeNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}


