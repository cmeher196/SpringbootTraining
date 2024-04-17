package com.example.demo.v1.services;


import com.example.demo.v1.dto.EmployeeRequestDTO;
import com.example.demo.v1.dto.EmployeeResponseDTO;
import com.example.demo.v1.model.Employee;
import com.example.demo.v1.model.TideEmployee;
import com.example.demo.v1.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeJPAService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeJPAService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO requestDTO){
        TideEmployee employee = new TideEmployee();
        employee.setName(requestDTO.getName());
        employee.setAddress(requestDTO.getAddress());
        employee.setEmailId(requestDTO.getEmailId());
        employee.setPhoneNo(requestDTO.getPhoneNo());
        TideEmployee employeeResponse = employeeRepository.save(employee);

        EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();
        responseDTO.setId(employeeResponse.getId());
        responseDTO.setName(employeeResponse.getName());
        responseDTO.setAddress(employeeResponse.getAddress());
        responseDTO.setEmailId(employeeResponse.getEmailId());
        responseDTO.setPhoneNo(employeeResponse.getPhoneNo());

        return responseDTO;

    }

    public EmployeeResponseDTO getEmployee(Long id){
        return new EmployeeResponseDTO();
    }

    public List<EmployeeResponseDTO> getAllEmployeesByAdressAndName(String name, String address){
        List<String> names   = employeeRepository.findByNameAndAddress(name, address);
        names.forEach(System.out::println);
//        tideEmployees.forEach(System.out::println);
        return List.of(new EmployeeResponseDTO());
    }

}
