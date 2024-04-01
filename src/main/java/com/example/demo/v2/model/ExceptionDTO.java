package com.example.demo.v2.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class ExceptionDTO {

    private String message;
    private HttpStatus httpStatus;

    public ExceptionDTO(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

}
