package com.taxcalculator.employeedata.dao;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.util.Set;


@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeSaveReq {
    @NotNull(message = "firstname is not provided")
    @NotBlank(message ="first is not provided" )
    private String firstName;
    @NotNull(message = "lastname is not provided")
    @NotBlank(message = "lastname is not provided")
    private String lastName;
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE,message = "email is invalid")
    @NotBlank(message = "email is not provided")
    private String email;
    @NotNull(message = "atleast one phone number required")
    private Set<String> phoneNumber;
    @NotNull(message = "date of join not provided")
    private LocalDateTime doj;
    @NotNull(message = "salary not provided")
    private double salary;
}
