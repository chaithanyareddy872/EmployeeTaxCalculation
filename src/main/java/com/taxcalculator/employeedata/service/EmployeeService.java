package com.taxcalculator.employeedata.service;

import com.taxcalculator.employeedata.dao.EmployeeSaveReq;
import com.taxcalculator.employeedata.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

    ResponseEntity<?> createEmployee(EmployeeSaveReq employeeSaveReq);

    ResponseEntity<?> getEmployeeTax(String email);
}
