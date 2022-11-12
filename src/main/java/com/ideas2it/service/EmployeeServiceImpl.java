package com.ideas2it.service;

import com.ideas2it.converter.EmployeeConverter;
import com.ideas2it.dto.EmployeeDto;
import com.ideas2it.exception.NotFoundException;
import com.ideas2it.model.Employee;
import com.ideas2it.dao.EmployeeDao;
import com.ideas2it.model.LeaveRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private EmployeeConverter employeeConverter;

    @Override
    public Employee insertEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeConverter.dtoToEmployee(employeeDto);
        return employeeDao.save(employee);
    }

    @Override
    public List<EmployeeDto> getEmployees() throws NotFoundException {
        List<Employee> employees = employeeDao.findAll();
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        if (employees.isEmpty()) {
            throw new NotFoundException("NO EMPLOYEE PRESENT IN DATABASE");
        }

        for (Employee employee: employees) {
            EmployeeDto employeeDto = employeeConverter.employeeToDto(employee);
            employeeDtos.add(employeeDto);
        }
        return employeeDtos;
    }

    @Override
    public EmployeeDto getEmployeeById(int employeeId) throws NotFoundException {
        Optional<Employee> employeeDetails = employeeDao.findById(employeeId);
        Employee employee;
        if (employeeDetails.isEmpty()) {
            throw new NotFoundException("EMPLOYEE NOT FOUND");
        } else {
            employee = employeeDetails.get();
            if(employee.getDeleted() == 1) {
                throw new NotFoundException("EMPLOYEE NOT FOUND");
            }
        }
        return employeeConverter.employeeToDto(employee);
    }

    @Override
     public Employee saveEmployee(Employee employee)  {
            employee.setModifiedAt(LocalDateTime.now().toString());
            return employeeDao.save(employee);
    }

    @Override
    public int removeEmployee(Employee employee) {
        employee.setDeleted(1);
        List<LeaveRecords> leaveRecords = employee.getLeaveRecords();
        for (LeaveRecords record : leaveRecords) {
            record.setDeleted(1);
        }
        return employeeDao.save(employee).getEmployeeId();
    }
}