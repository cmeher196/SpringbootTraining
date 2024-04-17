package com.example.demo.v1.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequestDTO {

    String name;
    String emailId;
    String phoneNo;
    String address;

}
