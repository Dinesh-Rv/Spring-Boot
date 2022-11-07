package com.ideas2it.service;

import com.ideas2it.model.Employee;
import com.ideas2it.dao.EmployeeDao;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
    //LeaveRecordsService leaveRecordServiceImpl = new LeaveRecordsServiceImpl();


    @Override
    public Employee insertEmployee(Employee employee) {
        //employee.setEmployeeId(getNewEmployeeId());
        employee.setCreatedAt(LocalDateTime.now().toString());
        employee.setModifiedAt(LocalDateTime.now().toString());

        return employeeDao.save(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeDao.findAll();
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        return employeeDao.findById(employeeId).get();
    }

    @Override
     public String updateEmployee(Employee employee) {
            /*employee.setModifiedAt(LocalDateTime.now().toString());
            return employeeDao.updateEmployee(employee);*/
            return null;
    }

    @Override
    public String removeEmployee(Employee employee) {
        /*
        if(employeeDao.removeEmployee(employee)!=0) {
            return employee.getEmployeeId() + " has deleted succesfully";
        }
        return employee.getEmployeeId() + " not deleted";*/
        return null;
    }

    @Override
    public boolean isPhoneNumberValid(String userPhoneNumber) {
        /*String phoneNumber = employeeDao.getEmployeePhoneNumber(userPhoneNumber);
        if(phoneNumber == null) {
            return true;
        }
        return false;*/
        return true;
    }

    @Override
    public boolean isEmailValid(String userEmail) {
        /*String emailId = employeeDao.getEmployeeEmail(userEmail);
        if(emailId == null) {
            return true;
        }
        return false;*/
        return true;
    }
}