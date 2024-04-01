package com.example.demo.v1.dto;

import com.example.demo.v1.model.Employee;
import lombok.Setter;

@Setter
public class ResponseDTO {

    private int count;
    private String status;
    private Employee employees;

}
