package com.example.demo.v1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponseDTO {
    Long id;
    String name;
    String emailId;
    String phoneNo;
    String address;
}
