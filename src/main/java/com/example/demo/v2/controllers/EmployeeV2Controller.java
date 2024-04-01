package com.example.demo.v2.controllers;


import com.example.demo.v2.exceptions.EmployeeNotFoundException;
import com.example.demo.v2.exceptions.ProductNotFoundException;
import com.example.demo.v2.model.Employee;
import com.example.demo.v2.model.EmployeeUpdateDTO;
import com.example.demo.v2.model.ExceptionDTO;
import com.example.demo.v2.services.EmployeeV2Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class EmployeeV2Controller {

    //CRUD : create/Read/Update/Delete

    private final EmployeeV2Service employeeV2Service;

    Logger logger = LoggerFactory.getLogger(EmployeeV2Controller.class);

    public EmployeeV2Controller(EmployeeV2Service employeeV2Service) {
        this.employeeV2Service = employeeV2Service;
    }

    @GetMapping("/healthCheck") // localhost:8080/api/v1/employees/healthcheck
    public String healthCheck() {

        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");

        return "V2 Service is up and running!!";
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET) // get all Employees
    public ResponseEntity<List<Employee>> getEmployee() { // get all Employees
        return new ResponseEntity<>(employeeV2Service.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/employees/{id}") // we need to send response for single employee
    public ResponseEntity getEmployeeById(@PathVariable Long id)  throws EmployeeNotFoundException {
        Employee employee = employeeV2Service.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        Employee employeResponse = employeeV2Service.addEmployee(employee);
        return new ResponseEntity<>(employeResponse.getName(), HttpStatus.CREATED);
    }

    @PutMapping("/employees") // update an employee
    public ResponseEntity<Employee> updateEmployee(@RequestBody EmployeeUpdateDTO updateDTO) { // update an employee
        return new ResponseEntity<>(employeeV2Service.updateEmployee(updateDTO), HttpStatus.OK); //200
    }

    @DeleteMapping("/{id}") // delete an employee
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) throws EmployeeNotFoundException {
        if (employeeV2Service.getEmployeeById(id) == null)
            return new ResponseEntity<>("Employee not found!!", HttpStatus.NOT_FOUND);
        else {
            Employee employeeResponse = employeeV2Service.deleteEmployee(id);
            return new ResponseEntity<>("Deleted Employee is " + employeeResponse.getName(), HttpStatus.OK);
        }
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<String> employeeNotFoundExpection(EmployeeNotFoundException ex){
        ExceptionDTO exceptionDTO = new ExceptionDTO(
                ex.getMessage(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(exceptionDTO.getMessage(), exceptionDTO.getHttpStatus());
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> productNotFoundExpection(EmployeeNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}


// __request:____service____:db:____service_____response-controller(ResponseEntity)__exposed______inject hacks___________client