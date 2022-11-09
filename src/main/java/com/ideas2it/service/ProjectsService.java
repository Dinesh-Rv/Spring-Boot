package com.ideas2it.service;
import com.ideas2it.model.Projects;

import java.util.List;

/**
 * EmployeeProjectService.java
 * <p>
 * Interface that acts as a service for employee Projects
 * </p>
 *
 * @author Dinesh Ravikumar
 * @since  at 04/11/2022
 */
public interface EmployeeProjectsService {
    /**
     * <p>
     * This method gets all the received inputted elements as a object
     * from the controller for the employee project creation
     * </p>
     *
     * @param record   Details of an employee to be passed to the dao(i.e a new employee)
     *
     * @return boolean element to confirm the record
     * is added successful in the database
     */ 
    public boolean addEmployeeProject(Projects record);

    /**
     * <p>
     *     gets all employee projects from the dao
     * </p>
     *
     * @return list of employee projects
     */
    public List<Projects> getAllProjects();

    /**
     * <p>
     * Gets leave records for an specific employee
     * </p>
     *
     * @param employeeId contains an employee Id
     * @return Details of projects of an employee
     */
    public List<Projects> getEmployeeProject(String employeeId);

    /**
     * <p>
     * passes the updated details to the dao
     * </p>
     *
     * @param projects
     *        the updated elements of a employee Project
     * @return a false boolean value if the update
process is successfull
     */
    public boolean updateEmployeeProjects(Projects projects);


}