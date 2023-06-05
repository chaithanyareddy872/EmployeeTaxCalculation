package com.taxcalculator.employeedata.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//database entity class to store employee details
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long employeId;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "Email")
    private String email;
    @Column(name = "PhoneNumber")
    private Set<String> phoneNumber;
    @Column(name = "DOJ")
    private LocalDateTime doj;
    @Column(name = "Salary")
    private double salary;
}
