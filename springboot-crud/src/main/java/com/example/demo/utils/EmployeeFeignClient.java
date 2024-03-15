package com.example.demo.utils;

import com.example.demo.config.Config;
import com.example.demo.entity.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "feign-client", url = "http://localhost:8080/api", configuration = Config.class)
public interface EmployeeFeignClient {
    @GetMapping("/employees/{employeeId}")
    Employee findById(@PathVariable("employeeId") int employeeId);

    @GetMapping("/employees")
    List<Employee> findAll();

    @PostMapping(value = "/employees", produces = "application/json")
    Employee create(Employee employee);
}
