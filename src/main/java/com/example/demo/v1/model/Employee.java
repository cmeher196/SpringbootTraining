package com.example.demo.v1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tide_employee")
public class Employee {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        Long id;
        String name;
        String emailId;
        String phoneNo;
        String address;

}


