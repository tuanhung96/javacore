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
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDTO> findAll() {
        return employeeRepository.findAll().stream()
                .map(EmployeeMapper::toEmployeeDTO)
                .toList();
    }

    @Override
    public EmployeeDTO findById(int employeeId) {
        Optional<Employee> result = employeeRepository.findById(employeeId);
        Employee employee = null;
        if (result.isPresent()) {
            employee = result.get();
        } else {
            throw new EmployeeNotFoundException("Did not find employee id - " + employeeId);
        }
        return EmployeeMapper.toEmployeeDTO(employee);
    }

    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        // convert employeeDTO to employee
        Employee employee = new Employee(employeeDTO.getFirstName(), employeeDTO.getLastName(), employeeDTO.getEmail());
        // save employee to database
        Employee savedEmployee = employeeRepository.save(employee);
        // convert employee to employeeDTO
        return EmployeeMapper.toEmployeeDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO update(int employeeId, EmployeeDTO employeeDTO) {
        // convert employeeDTO to employee
        Employee employee = new Employee(employeeId, employeeDTO.getFirstName(), employeeDTO.getLastName(), employeeDTO.getEmail());
        // save employee to database
        Employee updatedEmployee = employeeRepository.save(employee);
        // convert employee to employeeDTO
        return EmployeeMapper.toEmployeeDTO(updatedEmployee);
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

