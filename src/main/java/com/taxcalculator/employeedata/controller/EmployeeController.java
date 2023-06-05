package com.taxcalculator.employeedata.controller;

import com.taxcalculator.employeedata.dao.EmployeeSaveReq;
import com.taxcalculator.employeedata.model.Employee;
import com.taxcalculator.employeedata.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @PostMapping()
    public ResponseEntity<?> createEmployee(@RequestBody @Valid EmployeeSaveReq employeeSaveReq){
        return employeeService.createEmployee(employeeSaveReq);
    }
    @GetMapping("/taxstatement/{email}")
    public ResponseEntity<?> getEmployeeTax(@PathVariable("email") String email){
        return employeeService.getEmployeeTax(email);
    }
}
