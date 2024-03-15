package com.example.demo.controller;

import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest-template")
public class TestRestTemplateController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployees(@PathVariable int employeeId) {
        return restTemplate.getForObject("/" + employeeId, Employee.class);
    }

    @PostMapping("/employees")
    public Employee postEmployees() {
        Employee employee = new Employee();
        employee.setFirstName("Test");
        employee.setLastName("rest template");
        employee.setEmail("test1@gmail.com");
        return restTemplate.postForObject("/", employee, Employee.class);
    }

//    @PutMapping("/employees/{employeeId}")
//    public void put(@PathVariable int employeeId) {
//        Employee employee = new Employee();
//        employee.setId(employeeId);
//        employee.setFirstName("Test");
//        employee.setLastName("rest template");
//        employee.setEmail("test2@gmail.com");
//        restTemplate.put("/" + employeeId, employee);
//    }

    @PutMapping("/employees/{employeeId}")
    public Employee put(@PathVariable int employeeId) {
        Employee employee = new Employee();
        employee.setId(employeeId);
        employee.setFirstName("Test");
        employee.setLastName("rest template");
        employee.setEmail("test2@gmail.com");
        return restTemplate.exchange( "/" + employeeId,
                HttpMethod.PUT,
                new HttpEntity<>(employee),
                Employee.class,
                employeeId).getBody();
    }

//    @DeleteMapping("/employees/{employeeId}")
//    public void delete(@PathVariable int employeeId) {
//        restTemplate.delete("/" + employeeId);
//    }

    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<Void> delete(@PathVariable int employeeId) {
        return restTemplate.exchange( "/" + employeeId,
                HttpMethod.DELETE,
                null,
                Void.class,
                employeeId);
    }
}
