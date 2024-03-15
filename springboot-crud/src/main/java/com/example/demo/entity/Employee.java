package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @NotBlank(message = "First name must not be blank")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last name must not be blank")
    @Column(name = "last_name")
    private String lastName;

    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}", message = "Email is invalid")
    @Column(name = "email", unique = true)
    private String email;

}


