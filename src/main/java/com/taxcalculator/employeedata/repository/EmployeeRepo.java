package com.taxcalculator.employeedata.repository;

import com.taxcalculator.employeedata.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmployeeRepo extends CrudRepository<Employee,Long> {

    Optional<Employee> findByEmail(String email);
}
