package com.example.demo.v1.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeUpdateDTO {

    private Long id;
    private String name;
    private String phoneNo;
    private String address;

}
