package com.ideas2it.service;

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
     * @param record
     *        record of an employee leave to be passed to the dao(i.e a new leave record)
     *  
     * @return boolean element to confirm an employee
is added succesfully in the database
     *                  
     */ 
    public int addLeaveRecord(LeaveRecords record, Employee employee);


    /**
     * <p>
     * Gets leave records for an specific employee
     * </p>
     * @param employee
     *        contains an employee Id for comparing
     * @return Details of leave reports of an employee
     *
     */
    public List<LeaveRecords> getLeaveRecords(Employee employee);

    /**
     * <p>
     * passes the updated details to the dao
     * </p>
     *
     * @param leaveRecord
     *        the updated elements of a leave Record
     * @return a false boolean value if the update
process is successfull
     */
    public String updateLeaveRecords(LeaveRecords leaveRecord);

    /**
     * <p>
     * gets the certain leave record of an employee using
the leave record id
     * </p>
     *
     * @param userLeaveRecordId
     *        the updated elements of a leave Record
     * @return selected leave record
     */
    public LeaveRecords getLeaveRecordById(String userLeaveRecordId);

    public void removeEmployeeLeaveRecords(Employee employee);
}