package com.ideas2it.controller;

import com.ideas2it.exception.NotFoundException;
import com.ideas2it.model.Employee;
import com.ideas2it.model.LeaveRecords;
import com.ideas2it.service.ProjectsService;
import com.ideas2it.service.EmployeeService;
import com.ideas2it.service.LeaveRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * Controller for Employee Operations in an office
 * </p>
 *
 * @author Dinesh Kumar R
 * @since 2022/11/08
 *
 */
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private LeaveRecordsService leaveRecordsService;
    @Autowired
    private ProjectsService projectsService;


    /**
     * <p>
     *     inserts an new employee
     * </p>
     * @param employee
     *        has a new employee object
     *
     * @return the employee details recently added to the db
     */
    @PostMapping
    public Employee insertEmployee(@RequestBody Employee employee) {
       return employeeService.insertEmployee(employee);
    }

    /**
     * <p>
     *     inserts a leave record for an employee
     * </p>
     * @param employeeId
     *        contains an employee Id
     *
     * @return the newly added leave record
     * @throws NotFoundException
     *         throws exception if the employee id doesn't hold a valid employee
     */
    @PostMapping(value = "leaveRecord/insert/{employeeId}")
    public LeaveRecords insertLeaveRecord(@RequestBody LeaveRecords leaveRecords,
                                          @PathVariable("employeeId") int employeeId) throws NotFoundException {
        Employee employee = employeeService.getEmployeeById(employeeId);
        leaveRecords.setEmployee(employee);
        return leaveRecordsService.insertLeaveRecord(leaveRecords);
    }


    /**
     * <p>
     *     Gets all employees
     * </p>
     *
     * @return All employee details through a List
     * @throws NotFoundException
     *         Throws exception when there is no employee in the database
     */
    @GetMapping
    public List<Employee> getEmployees() throws NotFoundException {
        return employeeService.getEmployees();
    }

    /**
     * <p>
     *     gets leaveRecords of an employee
     * </p>
     * @param employeeId
     *        contains an employee id of an employee
     *
     * @return leave records of the employee
     * @throws NotFoundException
     *         throws exception if the employee id doesn't hold a valid employee
     */
    @GetMapping("leaveRecords/getByEmployee/{employeeId}")
    public List<LeaveRecords> getLeaveRecordByEmployee(@PathVariable("employeeId") int employeeId)
            throws NotFoundException {
        Employee employee = employeeService.getEmployeeById(employeeId);
        return employee.getLeaveRecords();
    }

    /**
     * <p>
     *     gets an employee by id to check to pass it to manage functions
     * </p>
     * @param employeeId
     *        contains an user entered employee Id
     * @return an employee object
     * @throws NotFoundException
     *         throws exception if the employee id doesn't hold a valid employee
     */
    @GetMapping("{employeeId}")
    public Employee getEmployeeById(@PathVariable("employeeId") int employeeId)
            throws NotFoundException {
        return employeeService.getEmployeeById(employeeId);
    }

    /**
     * <p>
     *     gets the leave record using the corresponding leave record id
     * </p>
     * @param leaveRecordId
     *        to get the leave record
     * @return single leave record object
     * @throws NotFoundException
     *         occurs when the leave record ID doesn't hold a leave record
     */
    @GetMapping("leaveRecords/getById/{leaveRecordId}")
    public LeaveRecords getLeaveRecordById(@PathVariable("leaveRecordId") int leaveRecordId) throws NotFoundException {
        return leaveRecordsService.getLeaveRecordById(leaveRecordId);
    }


    /**
     * <p>
     *     updates the employee using the new employee object
     * </p>
     * @param employee
     *        updated employee object
     *
     * @return the updated employee object
     */
    @PutMapping(value = "/saveEmployee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    /**
     * <p>
     *     deletes an employee
     * </p>
     * @param employeeId
     *        to get an employee
     *
     * @return a string information about which id of an employee is deleted
     */
    @PutMapping(value = "deleteEmployee/{employeeId}")
    public String deleteEmployee(@PathVariable("employeeId") int employeeId) throws NotFoundException {
        Employee employee = employeeService.getEmployeeById(employeeId);
        return employeeService.removeEmployee(employee) + " HAS BEEN DELETED SUCCESSFULLY";
    }
}
