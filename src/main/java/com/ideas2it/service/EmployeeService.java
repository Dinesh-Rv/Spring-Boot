package com.ideas2it.service;

import com.ideas2it.exception.NotFoundException;
import com.ideas2it.model.Employee;

import java.util.List;

public interface EmployeeService {

    /**
     * <p>
     * This method gets all the received inputted elements as a object
from the controller and passes it to the dao addition of employee
     * </p>
     *
     * @param employee
     *        Details of an employee to be passed to the dao(i.e a new employee)
     *  
     * @return boolean element to confirm an employee
is added succesfully in the database
     *                  
     */ 
    public Employee insertEmployee(Employee employee);

    /**
     * <p>
     * gets the details of all Employees
     * </p>
     *
     * @return details of all employee
     */
    public List<Employee> getEmployees() throws NotFoundException;

    /**
     * <p>
     * passes the updated details to the dao
     * </p>
     *
     * @param employee
     *        the updated elements of a single employee
     * @return a false boolean value if the update
process is successfull
     */
    public Employee saveEmployee(Employee employee);

    /**
     * <p>
     * Deletes an employee
     * <p>
     *
     * @param employee contains an employee object
     * @return returns the employee object
     */
    public int removeEmployee(Employee employee);

    /**
     * <p>
     * Gets a selective employee from the Data Base
     * </p>
     *
     * @param employeeId contains an employee Id to get details using id
     * @return Details of a single employee
     */
    public Employee getEmployeeById(int employeeId) throws NotFoundException;

}