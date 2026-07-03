package com.example.employee_svc.controller;

import com.example.employee_svc.dto.EmployeeDTO;
import com.example.employee_svc.entity.Employee;
import com.example.employee_svc.exception.ResourceNotFoundException;
import com.example.employee_svc.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(service.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = service.getEmployeeById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with ID " + id + " not found"));
        return ResponseEntity.ok(employee); // returns 200 OK with employee JSON
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDTO dto) {
        Employee created = service.createEmployee(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO dto) {
        Employee updated = service.updateEmployee(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>>  deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Employee with ID " + id + " deleted successfully");
        return ResponseEntity.ok(response);
    }
}
