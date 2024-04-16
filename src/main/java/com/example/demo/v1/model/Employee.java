package com.example.demo.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

//@Data
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


