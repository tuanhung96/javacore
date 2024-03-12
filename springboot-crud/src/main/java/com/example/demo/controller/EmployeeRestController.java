package com.example.demo.controller;

import com.example.demo.exception.handler.EmployeeNotFoundException;
import com.example.demo.model.dto.EmployeeDTO;
import com.example.demo.service.EmployeeService;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDTO>> findAll() {
        List<EmployeeDTO> employeeDTOList = employeeService.findAll();
        return ResponseEntity.ok(employeeDTOList);
    }

    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<EmployeeDTO> findById(@PathVariable @Min(1) int employeeId) {
        EmployeeDTO employeeDTO = employeeService.findById(employeeId);
        return ResponseEntity.ok(employeeDTO);
    }

    @PostMapping("/employees")
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO savedEmployee = employeeService.save(employeeDTO);
        return ResponseEntity.ok(savedEmployee);
    }

    @PutMapping("/employees/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable @Min(1) int employeeId,
                                                      @RequestBody EmployeeDTO employeeDTO) {
        if (!employeeService.existsById(employeeId)) throw new EmployeeNotFoundException("Did not find employee id - " + employeeId);
        EmployeeDTO updatedEmployee = employeeService.update(employeeId, employeeDTO);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable @Min(1) int employeeId) {
        if (!employeeService.existsById(employeeId)) throw new EmployeeNotFoundException("Did not find employee id - " + employeeId);
        employeeService.deleteById(employeeId);
        return "Deleted employee id" + employeeId;
    }
}

