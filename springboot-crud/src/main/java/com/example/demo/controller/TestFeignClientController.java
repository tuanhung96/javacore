package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.utils.EmployeeFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feign-client")
public class TestFeignClientController {
    @Autowired
    private  EmployeeFeignClient employeeFeignClient;

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        return employeeFeignClient.findById(employeeId);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeFeignClient.findAll();
    }

    @PostMapping("/employees")
    public Employee postEmployees() {
        Employee employee = new Employee();
        employee.setFirstName("Test");
        employee.setLastName("rest template");
        employee.setEmail("test1@gmail.com");
        return employeeFeignClient.create(employee);
    }
}
