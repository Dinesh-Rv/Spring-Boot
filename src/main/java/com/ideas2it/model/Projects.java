package com.ideas2it.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * EmployeeProjects.java
 *
 * <p> Contains every attribute for project record for
 * an employee, doesn't contain any i/o operation
 * </p>
 *
 */
@Entity
@Table(name = "projects")
public class Projects {

    @Id
    @GeneratedValue
    @Column(name = "project_id")
    private int projectId;
    @Column(name = "name")
    private String projectName;
    @Column(name = "manager")
    private String projectManager;
    @Column(name = "client")
    private String clientName;
    @Column(name = "start_date")
    private String startDate;
    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "modified_at")
    private String modifiedAt;
    @ManyToMany
    @JoinTable(name="employee_projects", joinColumns = {@JoinColumn(name="employee_id")}, inverseJoinColumns = {@JoinColumn(name = "project_id")})
    private List<Employee> employee;

    public  Projects() {

    }

    public Projects(String projectName,
                    String projectManager,
                    String clientName,
                    String startDate,
                    String createdAt,
                    String modifiedAt) {
        this.projectName = projectName;
        this.projectManager = projectManager;
        this.clientName = clientName;
        this.startDate = startDate;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getProjectId() {
        return projectId;
    }


    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartDate() {
        return startDate;
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

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "\nProject Id : "+ projectId + "\nProject Name : " + projectName +
                "\nProject Manager :" + projectManager + "\nClient Name : "+ clientName +
                "\n Starting date : " + startDate + "\n";
    }
}