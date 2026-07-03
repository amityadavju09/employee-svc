package com.example.employee_svc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "emp")
public class Employee {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name="employee_id")
    private Long employeeId;

    @Setter
    @Getter
    @Column( name="first_name", nullable = false, length = 50)
    private String firstName;

    @Setter
    @Getter
    @Column(nullable = false, length = 50, name="last_name")
    private String lastName;

    @Setter
    @Getter
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Setter
    @Getter
    @Column(nullable = false, length = 50, name="phone_number")
    private String phoneNumber;

    @Setter
    @Getter
    @Column(nullable = false, length = 50, name="created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Setter
    @Getter
    @Column(nullable = false, length = 50, name="updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    // Getters and Setters
}
