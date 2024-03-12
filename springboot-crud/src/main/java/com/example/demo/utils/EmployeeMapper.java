package com.example.demo.utils;

import com.example.demo.entity.Employee;
import com.example.demo.model.dto.EmployeeDTO;

public class EmployeeMapper {
    public static EmployeeDTO toEmployeeDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setEmail(employee.getEmail());
        return employeeDTO;
    }
}