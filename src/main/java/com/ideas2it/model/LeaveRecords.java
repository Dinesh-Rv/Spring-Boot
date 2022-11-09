package com.ideas2it.model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * LeaveRecords.java
 *
 * <p> Contains every attribute for leave records for
 * an employee, doesn't contain any i/o operation
 * </p>
 *
 * @author Dinesh Rv
 * @since 8/11/2022
 */
@Entity
@Table(name = "leave_records")
public class LeaveRecords {

    @Id
    @GeneratedValue
    private int leaveRecordId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "from_date")
    private String fromDate;
    @Column(name = "to_date")
    private String toDate;
    @Column(name = "leave_type")
    private String leaveType;
    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "modified_at")
    private String modifiedAt;
    @Column(name = "deleted")
    private int deleted;

    public LeaveRecords() {
    }

    public void setLeaveRecordId(int leaveRecordId) {
        this.leaveRecordId = leaveRecordId;
    }

    public int getLeaveRecordId() {		
        return leaveRecordId;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    } 

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }
	
    public String getFromDate() {
        return fromDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }	

    public String getToDate() {
        return toDate;
    }
 
    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getLeaveType() {		
        return leaveType;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }


    public int getDeleted() {
        return deleted;
    }

    @Override
    public String toString() {
        return "\n Employee ID :"+employee.getEmployeeId()+
                "\nLeave Reference Id :" + leaveRecordId
             + "\nLeave Type : " + leaveType 
             + "\nFrom :" + fromDate 
             + "\nTo : "+ toDate + "\n";
    }	
}