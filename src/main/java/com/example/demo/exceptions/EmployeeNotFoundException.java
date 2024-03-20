package com.example.demo.exceptions;

public class EmployeeNotFoundException extends Exception{

    public EmployeeNotFoundException(String errorMessage){
        super(errorMessage);
    }

}
