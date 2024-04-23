package com.example.demo.v1.controllers;


import com.example.demo.v1.dto.EmployeeRequestDTO;
import com.example.demo.v1.dto.EmployeeResponseDTO;
import com.example.demo.v1.services.EmployeeJPAService;
import com.example.demo.v1.services.EmployeeService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crud")
public class EmployeeJPAController {

    private final EmployeeJPAService employeeJPAService;

    @Autowired
    public EmployeeJPAController(EmployeeJPAService employeeJPAService) {
        this.employeeJPAService = employeeJPAService;
    }

    @PostMapping("/employee")
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeRequestDTO requestDTO){
        EmployeeResponseDTO responseDTO = employeeJPAService.createEmployee(requestDTO);
        return new ResponseEntity<>(responseDTO.getName(), HttpStatus.CREATED);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeResponseDTO>> getEmployees(){

        return new ResponseEntity<>(employeeJPAService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeResponseDTO> getEmployeeById(@PathVariable Long id){
        EmployeeResponseDTO responseDTO = employeeJPAService.getEmployee(id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/employee/{name}/{address}")
    public ResponseEntity<EmployeeResponseDTO> getEmployee(@PathVariable String name , @PathVariable String address){
        EmployeeResponseDTO responseDTO = employeeJPAService.getAllEmployeesByAdressAndName(name, address).get(0);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    @PutMapping("/employee/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequestDTO requestDTO){
        EmployeeResponseDTO responseDTO = employeeJPAService.updateEmployee(id, requestDTO);
        return new ResponseEntity<>(responseDTO.getName(), HttpStatus.OK);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        String deleteResponse = employeeJPAService.deleteEmployee(id);
        return new ResponseEntity<>(deleteResponse, HttpStatus.OK);
    }
}
