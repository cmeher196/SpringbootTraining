package com.example.demo.v2.exceptions;

public class EmployeeNotFoundException extends Exception{
    public EmployeeNotFoundException(String msg){
        super(msg);
    }
}
