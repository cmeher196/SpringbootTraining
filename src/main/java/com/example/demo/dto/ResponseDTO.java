package com.example.demo.dto;

import com.example.demo.model.Employee;
import lombok.Setter;

import java.util.List;

@Setter
public class ResponseDTO {

    private int count;
    private String status;
    private Employee employees;

}
