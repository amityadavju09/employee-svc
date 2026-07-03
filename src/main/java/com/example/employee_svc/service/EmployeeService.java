package com.example.employee_svc.service;

import com.example.employee_svc.dto.EmployeeDTO;
import com.example.employee_svc.entity.Employee;
import com.example.employee_svc.exception.ResourceNotFoundException;
import com.example.employee_svc.repository.EmployeeRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return repository.findById(id);
    }

    public Employee createEmployee(EmployeeDTO dto) {
        Employee employee = new Employee();
        return repository.save(getEmployeeObj(dto, employee));
    }

    @NonNull
    private Employee getEmployeeObj(EmployeeDTO dto, Employee employee) {
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());
        employee.setPhoneNumber(dto.getPhoneNumber());
        return employee;
    }

    public Employee updateEmployee(Long id, EmployeeDTO dto) {
        return repository.findById(id).map(emp -> {
            emp.setFirstName(dto.getFirstName());
            emp.setLastName(dto.getLastName());
            emp.setEmail(dto.getEmail());
            emp.setPhoneNumber(dto.getPhoneNumber());
            emp.setUpdatedAt(LocalDateTime.now());
            return repository.save(emp);
        }).orElseThrow(() -> new ResourceNotFoundException("Employee with ID " + id + " not found"));
    }

    public void deleteEmployee(Long id) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with ID " + id + " not found"));
        repository.deleteById(id);
    }
}
