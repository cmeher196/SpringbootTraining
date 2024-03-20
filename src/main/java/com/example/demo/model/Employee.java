package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Employee {

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
