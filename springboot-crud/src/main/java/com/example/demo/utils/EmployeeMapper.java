package com.example.demo.utils;

import com.example.demo.entity.Employee;
import com.example.demo.model.dto.EmployeeDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDTO employeeToEmployeeDTO(Employee entity);
    Employee employeeDTOtoEmployee(EmployeeDTO dto);
}
