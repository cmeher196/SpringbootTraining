package com.example.demo.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

//@Data
@Data
@Entity(name = "tide_employee")
public class Employee {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @JsonProperty("Id")
        Long id;
        @JsonProperty("Name")
        String name;
        @JsonProperty("EmailId")
        String emailId;
        @JsonProperty("PhoneNo")
        String phoneNo;
        @JsonProperty("Address")
        String address;



}


