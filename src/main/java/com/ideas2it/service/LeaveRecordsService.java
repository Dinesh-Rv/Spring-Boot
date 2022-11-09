package com.ideas2it.service;

import com.ideas2it.exception.NotFoundException;
import com.ideas2it.model.LeaveRecords;
import com.ideas2it.model.Employee;

import java.util.List;

public interface LeaveRecordsService {
    /**
     * <p>
     * This method gets all the received inputted elements as a object
from the controller for the leave record creation
     * </p>
     *
     * @param leaveRecords
     *        record of an employee leave to be passed to the dao(i.e a new leave record)
     *  
     * @return boolean element to confirm an employee
is added succesfully in the database
     *                  
     */ 
    public LeaveRecords insertLeaveRecord(LeaveRecords leaveRecords);

    /**
     * <p>
     * gets the certain leave record of an employee using
the leave record id
     * </p>
     *
     * @param leaveRecordId
     *        leave Record ID
     * @return Leave Record object using id
     */
    public LeaveRecords getLeaveRecordById(int leaveRecordId) throws NotFoundException;
}