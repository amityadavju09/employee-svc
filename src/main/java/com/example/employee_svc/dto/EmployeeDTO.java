package com.example.employee_svc.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class EmployeeDTO {
    private Long employeeId;
    @Setter
    @Getter
    private String firstName;
    @Setter
    @Getter
    private String lastName;
    @Setter
    @Getter
    private String email;
    @Setter
    @Getter
    private String phoneNumber;
    @Setter
    @Getter
    private String createdAt;
    @Setter
    @Getter
    private String updatedAt;

    // Getters and Setters
}
