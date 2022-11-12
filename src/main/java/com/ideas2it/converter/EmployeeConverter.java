package com.ideas2it.converter;

import com.ideas2it.dto.EmployeeDto;
import com.ideas2it.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter {

    public EmployeeDto employeeToDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto(employee.getEmployeeId(),
                                                  employee.getEmployeeName(),
                                                  employee.getEmployeeDepartment(),
                                                  employee.getEmployeePhoneNumber(),
                                                  employee.getEmployeeDateOfBirth(),
                                                  employee.getEmployeeEmail(),
                                                  employee.getEmployeeRole(),
                                                  employee.getEmployeeGender());
        return employeeDto;
    }

    public Employee dtoToEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(employeeDto.getEmployeeName(),
                                         employeeDto.getEmployeeRole(),
                                         employeeDto.getEmployeeDepartment(),
                                         employeeDto.getEmployeePhoneNumber(),
                                         employeeDto.getEmployeeDateOfBirth(),
                                         employeeDto.getEmployeeGender(),
                                         employeeDto.getEmployeeEmail(),
                                         employeeDto.getEmployeeId());
        return employee;
    }
}
