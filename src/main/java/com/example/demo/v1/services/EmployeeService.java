package com.example.demo.v1.services;


import com.example.demo.v1.exceptions.EmployeeNotFoundException;
import com.example.demo.v1.model.Employee;
import com.example.demo.v1.model.EmployeeUpdateDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final List<Employee> employees;

    public EmployeeService() {
        employees = new ArrayList<>();
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployeeById(Long id) throws EmployeeNotFoundException {
        Optional<Employee> matchedEmployee = employees.stream()
                                    .filter(e -> e.getId().equals(id))
                                    .findFirst();

        if(matchedEmployee.isPresent())
            return matchedEmployee.get();
        else
            throw new EmployeeNotFoundException("Employee not found");
    }

    public Employee addEmployee(Employee employee) { // no db // list<employees>
        employees.add(employee);
        return employee;
    }

    public Employee updateEmployee(EmployeeUpdateDTO updateDTO) {
        Employee employee = new Employee();
        if(updateDTO != null) {
            Optional<Employee> matchedEmployee = employees.stream()
                    .filter(e -> e.getId().equals(updateDTO.getId()))
                    .findFirst();
            if(matchedEmployee.isPresent()) {
                employee = matchedEmployee.get();
                employee.setName(updateDTO.getName());
                employee.setPhoneNo(updateDTO.getPhoneNo());
                employee.setAddress(updateDTO.getAddress());
            }
        }
        return employee;
    }

    public Employee deleteEmployee(Long id) {
        Optional<Employee> matchedEmployee = employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();

        return matchedEmployee.map(employee -> {
            employees.remove(employee); //Arraylist remove()
            return employee;
        }).orElseGet(Employee::new);

//        if(matchedEmployee.isPresent()) {
//            employees.remove(matchedEmployee.get());
//            return matchedEmployee.get();
//        }
//        else
//            return matchedEmployee.orElse(new Employee());
    }
}

// function level : throws , throw: block level