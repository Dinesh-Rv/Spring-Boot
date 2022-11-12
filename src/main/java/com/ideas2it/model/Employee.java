package com.ideas2it.model;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

/**
 * Employee.java
 *
 * <p> Contains every attribute common for all employee, doesn't contain
 * any input or output operations
 * </p>
 *
 * @author Dinesh Rv
 * @since 8/11/2022
 */
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue
    private int employeeId;

    @Column(name = "name")
    private String employeeName;

    @Column(name = "department")
    private String employeeDepartment;

    @Column(name = "phone_number")
    private String employeePhoneNumber;
    @Column(name = "dob")
    private String employeeDateOfBirth;
    @Column(name = "email")
    private String employeeEmail;
    @Column(name = "role")
    private String employeeRole;
    @Column(name = "gender")
    private String employeeGender;
    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "modified_at")
    private String modifiedAt;
    @Column(name = "deleted")
    private int deleted = 0;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY ,mappedBy = "employee", cascade = CascadeType.ALL)
    private List<LeaveRecords> leaveRecords;

    @ManyToMany(mappedBy = "employee")
    private List<Projects> projects;

    public Employee () {
    }

    public Employee(String employeeName,
                    String employeeRole,
                    String employeeDepartment,
                    String employeePhoneNumber,
                    String employeeDateOfBirth,
                    String employeeGender,
                    String employeeEmail,
                    int employeeId) {
        this.employeeName = employeeName;
        this.employeeDepartment = employeeDepartment;
        this.employeePhoneNumber = employeePhoneNumber;
        this.employeeDateOfBirth = employeeDateOfBirth;
        this.employeeEmail = employeeEmail;
        this.employeeId = employeeId;
        this.employeeRole = employeeRole;
        this.employeeGender = employeeGender;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeName() {		
        return employeeName;
    } 

    public void setEmployeeDepartment(String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    public String getEmployeeDepartment() {		
	return employeeDepartment;
    }

    public void setEmployeePhoneNumber(String employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }
	
    public String getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }	

    public int getEmployeeId() {
        return  employeeId;
    }
 
    public void setEmployeeDateOfBirth(String employeeDateOfBirth) {
        this.employeeDateOfBirth = employeeDateOfBirth;
    }

    public String getEmployeeDateOfBirth() {	
        return employeeDateOfBirth;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }  

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }

    public String getEmployeeRole() {		
        return employeeRole;
    } 

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public String getEmployeeGender() {		
        return employeeGender;
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

    public void setLeaveRecords(List<LeaveRecords> leaveRecords) {
        this.leaveRecords = leaveRecords;
    }
    public List<LeaveRecords> getLeaveRecords() {
        return leaveRecords;
    }

    public void setEmployeeProjects(List<Projects> projects) {
        this.projects = projects;
    }

    public List<Projects> getProjects() {
        return projects;
    }
    @Override
    public String toString() {
        String displayEmployeeDetail = "\nEmployee Id : "+ employeeId + "\nEmployee Role : " + employeeRole +
                                       "\nDepartment :" + employeeDepartment + "\nName : "+employeeName + 
                                       "\nDate of birth :" + employeeDateOfBirth + "\nPhone Number :" + employeePhoneNumber + 
                                       "\nEmail ID :" + employeeEmail + "\nGender : " + employeeGender + "\n";
        return displayEmployeeDetail;
    }	
}