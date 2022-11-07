package com.ideas2it.service;

import com.ideas2it.model.Employee;

import java.util.List;
import java.util.Optional;

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
    public List<Employee> getEmployees();

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
    public String updateEmployee(Employee employee);

    /**
     * <p>
     * Deletes an employee
     * <p>
     * @param employee
     *        contains an employee Object
     *
     * @return a boolean to confirm if the employee is deleted successfully
     *
     */
    public String removeEmployee(Employee employee);

    /**
     * <p>
     * Gets a selective employee from the Data Base
     * </p>
     *
     * @param employeeId contains an employee Id to get details using id
     * @return Details of a single employee
     */
    public Employee getEmployeeById(int employeeId);

    /**
     * <p>
     *     checks if the user phone number
     *     already exist in db
     * </p>
     * @param userPhoneNumber
     * @return true if the userPhoneNumber is unique
     */
    public boolean isPhoneNumberValid(String userPhoneNumber);

    /**
     * <p>
     *     checks if the user email
     *     already exist in db
     * </p>
     * @param userEmail
     * @return true if the userEmail is unique
     */
    public boolean isEmailValid(String userEmail);

}