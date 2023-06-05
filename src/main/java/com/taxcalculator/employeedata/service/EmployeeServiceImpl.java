package com.taxcalculator.employeedata.service;

import com.taxcalculator.employeedata.dao.EmployeeSaveReq;
import com.taxcalculator.employeedata.dao.EmployeeSaveRes;
import com.taxcalculator.employeedata.dao.EmployeeTaxRes;
import com.taxcalculator.employeedata.exceptions.EmployeeNotFoundException;
import com.taxcalculator.employeedata.model.Employee;
import com.taxcalculator.employeedata.repository.EmployeeRepo;
import com.taxcalculator.employeedata.validation.TaxCompute;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import java.util.Optional;


@Service
//providing method implementations
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    EmployeeSaveRes employeeSaveRes;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    TaxCompute taxCompute;


    @Transactional
    @Override
    //method to create an employee
    public ResponseEntity<?> createEmployee(EmployeeSaveReq employeeSaveReq) {
        //mapping the request and entity using modelmapper
        Employee employee=modelMapper.map(employeeSaveReq,Employee.class);
        //calling the save method to save emp details
        try {
            employee=employeeRepo.save(employee);
        }

        catch (TransactionSystemException e){
            return new ResponseEntity<>(e.getRootCause().getMessage()
                    .contains("email is invalid")?"email is invalid":"input fields are wrong", HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            return new ResponseEntity<>("something went wrong in saving data",HttpStatus.BAD_REQUEST);
        }
        if(employee.getEmployeId()!=0){
            employeeSaveRes.setMessage("successfully stored");
        }else {
            employeeSaveRes.setMessage("something went wrong");
        }
        return new ResponseEntity<>(employeeSaveRes, HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<?> getEmployeeTax(String email) {
        Employee employee=employeeRepo.findByEmail(email).orElseThrow(()->{return new EmployeeNotFoundException("user doesnot exist with the give email");});
        Double tax=taxCompute.taxCal(taxCompute.totalsal(employee.getDoj(),employee.getSalary()));
        EmployeeTaxRes employeeTaxRes=new EmployeeTaxRes(employee.getEmployeId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getSalary()*12,
                tax,taxCompute.cesAmount(employee.getSalary()));
        return new ResponseEntity<>(employeeTaxRes,HttpStatus.ACCEPTED);
    }
}
