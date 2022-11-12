package com.ideas2it.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private int employeeId;
    private String employeeName;
    private String employeeDepartment;
    private String employeePhoneNumber;
    private String employeeDateOfBirth;
    private String employeeEmail;
    private String employeeRole;
    private String employeeGender;
}
