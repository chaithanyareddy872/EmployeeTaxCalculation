package com.taxcalculator.employeedata.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeSaveRes {
    private String message;
}
