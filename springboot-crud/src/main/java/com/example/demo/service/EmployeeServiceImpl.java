package com.example.demo.service;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.entity.Employee;
import com.example.demo.exception.handler.EmployeeNotFoundException;
import com.example.demo.model.dto.EmployeeDTO;
import com.example.demo.utils.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeDTO> findAll() {
        return employeeRepository.findAll().stream()
                .map(employee -> employeeMapper.employeeToEmployeeDTO(employee))
                .toList();
    }

    @Override
    public EmployeeDTO findById(int employeeId) {
        Optional<Employee> result = employeeRepository.findById(employeeId);
        Employee employee = null;
        if (result.isPresent())  employee = result.get();
        else throw new EmployeeNotFoundException("Did not find employee id - " + employeeId);

        return employeeMapper.employeeToEmployeeDTO(employee);
    }

    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.employeeDTOtoEmployee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);

        return employeeMapper.employeeToEmployeeDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO update(int employeeId, EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.employeeDTOtoEmployee(employeeDTO);
        employee.setId(employeeId);

        Employee updatedEmployee = employeeRepository.save(employee);

        return employeeMapper.employeeToEmployeeDTO(updatedEmployee);
    }

    @Override
    public boolean existsById(int employeeId) {
        return employeeRepository.existsById(employeeId);
    }

    @Override
    public void deleteById(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}

