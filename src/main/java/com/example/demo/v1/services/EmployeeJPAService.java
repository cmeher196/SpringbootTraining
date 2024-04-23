package com.example.demo.v1.services;


import com.example.demo.v1.dto.EmployeeRequestDTO;
import com.example.demo.v1.dto.EmployeeResponseDTO;
import com.example.demo.v1.model.TideEmployee;
import com.example.demo.v1.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

public List<EmployeeResponseDTO> getAllEmployees(){
        Optional<List<TideEmployee>> tideEmployees = Optional.of(employeeRepository.findAll());
        if(tideEmployees.isEmpty()){
            return List.of(new EmployeeResponseDTO());
        }
        else{
            tideEmployees.get().forEach(System.out::println);
        }
        List<EmployeeResponseDTO> employeeResponseDTOList = new ArrayList<>();

        tideEmployees.get().forEach(emp ->{
            EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();
            responseDTO.setId(emp.getId());
            responseDTO.setName(emp.getName());
            responseDTO.setAddress(emp.getAddress());
            responseDTO.setEmailId(emp.getEmailId());
            responseDTO.setPhoneNo(emp.getPhoneNo());
            employeeResponseDTOList.add(responseDTO);
        });
        return employeeResponseDTOList;
    }

    public EmployeeResponseDTO getEmployee(Long id){
        Optional<TideEmployee> tideEmployee =  employeeRepository.findById(id);
        EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();
        if(tideEmployee.isEmpty()){
            return responseDTO;
        }
        TideEmployee employee = tideEmployee.get();
        responseDTO.setId(employee.getId());
        responseDTO.setName(employee.getName());
        responseDTO.setAddress(employee.getAddress());
        responseDTO.setEmailId(employee.getEmailId());
        responseDTO.setPhoneNo(employee.getPhoneNo());
        return responseDTO;

    }

    public List<EmployeeResponseDTO> getAllEmployeesByAdressAndName(String name, String address){
        List<String> names   = employeeRepository.findByNameAndAddress(name, address);
        names.forEach(System.out::println);
//        tideEmployees.forEach(System.out::println);
        return List.of(new EmployeeResponseDTO());
    }

    //saveOrUpdate() -> ps.update(query)->update / insertion
    //update -> update
    //all the are deprecated now

    //save() from crudRepository -> save / insert

    public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO requestDTO){
        Optional<TideEmployee> tideEmployee = employeeRepository.findById(id);
        if(tideEmployee.isEmpty()){
            return new EmployeeResponseDTO();
        }
        TideEmployee employee = tideEmployee.get();
        //once we got the current employee we are replacing with the request
        employee.setName(requestDTO.getName());
        employee.setAddress(requestDTO.getAddress());
        employee.setEmailId(requestDTO.getEmailId());
//        if(requestDTO.getPhoneNo() != null){
//            employee.setPhoneNo(requestDTO.getPhoneNo());
//        }
//        employee.setPhoneNo(requestDTO.getPhoneNo());
        TideEmployee employeeResponse = employeeRepository.save(employee); // update

        EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();
        responseDTO.setId(employeeResponse.getId());
        responseDTO.setName(employeeResponse.getName());
        responseDTO.setAddress(employeeResponse.getAddress());
        responseDTO.setEmailId(employeeResponse.getEmailId());
        responseDTO.setPhoneNo(employeeResponse.getPhoneNo());

        return responseDTO;
    }

    public String deleteEmployee(Long id){
        Optional<TideEmployee> tideEmployee = employeeRepository.findById(id);
        if(tideEmployee.isEmpty()){
          return "Employee not found";
        }
        TideEmployee employee = tideEmployee.get();
        employeeRepository.delete(employee);
        EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();
        responseDTO.setName(employee.getName());
        return responseDTO.getName();
    }


}
