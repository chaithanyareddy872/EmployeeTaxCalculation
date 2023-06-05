package com.taxcalculator.employeedata.dao;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeTaxRes {
    private long employeId;
    private String firstName;
    private String lastName;
    private double salary;
    private double tax;
    private double cess;
}
