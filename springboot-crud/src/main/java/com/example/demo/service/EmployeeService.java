package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.model.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO>  findAll();

    EmployeeDTO findById(int id);

    EmployeeDTO save(EmployeeDTO employeeDTO);

    EmployeeDTO update(int employeeId, EmployeeDTO employeeDTO);

    boolean existsById(int id);

    void deleteById(int id);
}
