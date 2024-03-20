package com.example.demo.controllers;


import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableCaching
public class Controller {

    @GetMapping("/test")
    public ResponseEntity<String> testData() {
        System.out.println("before response1");
        for(int i =1;i< 1000000000;i++){}
        System.out.println("after response1");
        RestTemplate restTemplate = new RestTemplate();
        String data  =  restTemplate.getForObject("https://dummyjson.com/products", String.class);
        return new ResponseEntity<>( data,HttpStatus.OK);
    }


    @GetMapping("/tests")
    public ResponseEntity<String> testData1() {
        System.out.println("before response12");
        for(int i =1;i< 100000;i++){}
        System.out.println("after response12");
        return new ResponseEntity<>( "Fine1",HttpStatus.OK);
    }
}
