package com.ideas2it.service;

import com.ideas2it.converter.EmployeeConverter;
import com.ideas2it.dao.EmployeeDao;
import com.ideas2it.dto.EmployeeDto;
import com.ideas2it.exception.NotFoundException;
import com.ideas2it.model.LeaveRecords;
import com.ideas2it.model.Employee;

import com.ideas2it.dao.LeaveRecordsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LeaveRecordsServiceImpl implements LeaveRecordsService {

    @Autowired
    private LeaveRecordsDao leaveRecordsDao;

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private EmployeeConverter employeeConverter;


    @Override
    public LeaveRecords insertLeaveRecord(LeaveRecords leaveRecords, EmployeeDto employeeDto) {
        Employee employee = employeeConverter.dtoToEmployee(employeeDto);
        leaveRecords.setEmployee(employee);
        leaveRecords.setCreatedAt(LocalDateTime.now().toString());
        leaveRecords.setModifiedAt(LocalDateTime.now().toString());
        return leaveRecordsDao.save(leaveRecords);

    }
    @Override
    public LeaveRecords getLeaveRecordById(int leaveRecordId) throws NotFoundException {
        Optional<LeaveRecords> leaveRecord =leaveRecordsDao.findById(leaveRecordId);
        if (leaveRecord.isEmpty()) {
            throw new NotFoundException("LEAVE RECORD NOT FOUND");
        }
        return leaveRecord.get();
    }

    @Override
    public List<LeaveRecords> getLeaveRecordsByEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeDao.findById(employeeDto.getEmployeeId()).get();
        return employee.getLeaveRecords();
    }
}