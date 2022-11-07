package com.ideas2it.controller;

import com.ideas2it.model.Employee;
import com.ideas2it.model.Projects;
import com.ideas2it.model.LeaveRecords;
import com.ideas2it.service.EmployeeProjectsService;
import com.ideas2it.service.EmployeeService;
import com.ideas2it.service.LeaveRecordsService;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Iterator;
import java.util.List;

/**
 * <p>
 * Controller for Employee Operations in an office
 * </p>
 *
 * @author Dinesh Kumar R
 * @since 2022/11/04
 *
 */
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final LeaveRecordsService leaveRecordsService;

    private final EmployeeProjectsService employeeProjectsService;
    public EmployeeController(EmployeeService employeeService, LeaveRecordsService leaveRecordsService, EmployeeProjectsService employeeProjectsService) {
        this.employeeService = employeeService;
        this.leaveRecordsService = leaveRecordsService;
        this.employeeProjectsService = employeeProjectsService;
    }

    /**
     * <p>
     *     inserts an new employee
     * </p>
     * @param employee
     *        has a new employee object
     *
     * @return employee creation page
     */
    @PostMapping
    public Employee insertEmployee(@RequestBody Employee employee) {
       return employeeService.insertEmployee(employee);
    }

    /**
     * <p>
     *     Gets all employees
     * </p>
     *
     * @return All employee details through a List
     */
    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    /**
     * <p>
     *     gets an employee by id to check to pass it to manage functions
     * </p>
     * @param employeeId
     *        contains an employee Id
     * @return modify employee page
     */
    @GetMapping("/{employeeId}")
    public Employee getEmployeeById(@PathVariable("employeeId") int employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    /**
     * <p>
     *     Gets all projects and sends them to the view
     * </p>
     * @param modelMap
     *        contains a model map to view the list of projects
     *
     * @return page to read all project details
     */
    @RequestMapping(value = "ReadAllProjects")
    public String readAllProjects(ModelMap modelMap) {
        modelMap.addAttribute("projects", employeeProjectsService.getAllProjects());
        return "readAllProjects";
    }

    /**
     * <p>
     *     gets employee by id to edit
     * </p>
     * @param employeeId
     *        contains an employee id
     * @param model
     *        contains a model to add attribute
     * @return employee update page
     */
    @RequestMapping(value = "/editEmployee/{employeeId}")
    public String editEmployeePage(@PathVariable int employeeId, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(employeeId));
        return "updateEmployee";
    }

    /**
     * <p>
     *     gets an employee for leave records page
     * </p>
     * @param employeeId
     *        employee id to get an employee
     * @param model
     *        to add attribute
     *
     * @return leave records page
     */
    @RequestMapping(value = "leaveRecords/{employeeId}")
    public String leaveRecordsPage(@PathVariable int employeeId, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(employeeId));
        return "leaveRecords";
    }

    /**
     * <p>
     *     gets all leave records
     * </p>
     * @param employeeId
     *        employee id to get corresponding leave records
     * @param redirectAttributes
     *        to add flash attributes for redirect page
     *
     * @return back to manage employee page
     */
    @RequestMapping(value = "leaveRecords/readAllLeaveRecords/{employeeId}")
    public String getAllLeaveRecord(@PathVariable int employeeId, RedirectAttributes redirectAttributes) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        redirectAttributes.addFlashAttribute("message", leaveRecordsService.getLeaveRecords(employee));
        return "redirect:/manageEmployee";
    }

    /**
     * <p>
     *     updates the employee using the new employee object
     * </p>
     * @param employee
     *        updated employee object
     * @param redirectAttributes
     *        to add flash attributes for redirect page
     *
     * @return back to employee crud page
     */
    @RequestMapping(value = "editEmployee/{employeeId}/UpdateEmployee", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("employee") Employee employee, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", employeeService.updateEmployee(employee));
        return "redirect:/employee";
    }

    /**
     * <p>
     *     deletes an employee
     * </p>
     * @param employeeId
     *        to get an employee
     * @param redirectAttributes
     *        to add attribute message to delete information if its deleted or not
     *
     * @return employee page
     */
    @RequestMapping(value = "deleteEmployee/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId, RedirectAttributes redirectAttributes) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        redirectAttributes.addFlashAttribute("message", employeeService.removeEmployee(employee));
        return "redirect:/employee";
    }

    /**
     * <p>
     *     sends the employee details for leave record form
     * </p>
     * @param employeeId
     *        to get employee
     * @param model
     *        to add employee for leave records form
     *
     * @return create leave record page
     */
    @RequestMapping(value = "leaveRecords/CreateLeaveRecord/{employeeId}")
    public String leaveRecordForm(@PathVariable int employeeId, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(employeeId));
        return "createLeaveRecord";
    }

    /**
     * <p>
     *     adds an leave record for the employee
     * </p>
     * @param employee
     *        contains and employee to mark leave record
     * @param leaveRecord
     *        contains the inputted leave record from the form
     * @param redirectAttributes
     *        to add message if the process is success and add
     *        flash attribute to the redirected page
     *
     * @return redirect to manage employee page
     */
    @PostMapping(value = "/leaveRecords/CreateLeaveRecord/AddLeaveRecord")
    public String addLeaveRecord(Employee employee, LeaveRecords leaveRecord, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", leaveRecordsService.addLeaveRecord(leaveRecord, employee));
        return "redirect:/manageEmployee";
    }

    /**
     * <p>
     *     iterates leave records of an employee
     *     and shows them in each slot in leave records selection page
     * </p>
     * @param employeeId
     *        to get the associated employee
     * @param model
     *        to add each leave record
     *
     * @return page where user gets to select an leave record
     */
    @RequestMapping(value = "leaveRecords/selectLeaveRecord/{employeeId}")
    public String selectLeaveRecord(@PathVariable int employeeId, Model model) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        List<LeaveRecords> leaveRecords = leaveRecordsService.getLeaveRecords(employee);
        Iterator<LeaveRecords> iterator = leaveRecords.iterator();

        while (iterator.hasNext()) {
            for (int i = 0; i<leaveRecords.size(); i++) {
                String recordName = "leaveRecord" + i;
                model.addAttribute(recordName, iterator.next());
            }
        }
        return "selectLeaveRecord";
    }

    /**
     * <p>
     *    gets an single leave record after the user selects the leave record
     * </p>
     * @param leaveRecordId
     *        contains the id for the leave record
     * @param model
     *        to add attribute to make sure if it gets the leave record,
     * @param redirectAttributes
     *        redirects to manage employee page if leave records not found
     *
     * @return next page based upon the user valid input
     */
    @RequestMapping(value = "leaveRecords/selectLeaveRecord/GetLeaveRecordById")
    public String getLeaveRecord(String leaveRecordId, Model model, RedirectAttributes redirectAttributes) {
        String nextPage;
        LeaveRecords leaveRecord = leaveRecordsService.getLeaveRecordById(leaveRecordId);
        if(leaveRecord != null) {
            model.addAttribute("leaveRecord", leaveRecordsService.getLeaveRecordById(leaveRecordId));
            nextPage = "updateLeaveRecord";
        } else {
            redirectAttributes.addFlashAttribute("message", "An Error Occurred");
            nextPage = "redirect:/manageEmployee";
        }
        return nextPage;
    }

    /**
     * <p>
     *     updates leave records
     * </p>
     * @param leaveRecord
     *        contains an updated leave record
     * @param redirectAttributes
     *        redirect a flash attribute after updating the leave record
     *
     * @return redirect to manage employee page
     */
    @PostMapping(value = "leaveRecords/selectLeaveRecord/UpdateLeaveRecord")
    public String updateLeaveRecord(LeaveRecords leaveRecord, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", leaveRecordsService.updateLeaveRecords(leaveRecord));
        return "redirect:/manageEmployee";
    }

    /**
     * <p>
     *     gets employee for employee project page
     * </p>
     * @param employeeId
     *        for getting an employee
     * @param model
     *        to add employee for the page
     *
     * @return employee projects crud page
     */
    @RequestMapping(value = "employeeProjects/{employeeId}")
    public String employeeProjectPage(@PathVariable int employeeId, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(employeeId));
        return "employeeProjects";
    }

    /**
     * <p>
     *     gets an employee to create a new project
     * </p>
     * @param employeeId
     *        to get an employee
     * @param model
     *        to add employee to add project for the corresponding employee
     *
     * @return new project creation page
     */
    @RequestMapping(value = "employeeProjects/manageNewProject/{employeeId}")
    public String manageNewProject(@PathVariable int employeeId, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(employeeId));
        return "manageNewProject";
    }

    /**
     * <p>
     *     adds employee project
     * </p>
     * @param employeeProjects
     *        contains the new project details
     * @param redirectAttributes
     *        to add flash attribute to show the process detail
     *
     * @return manage employee page
     */
    @PostMapping(value = "employeeProjects/manageNewProject/createNewProject")
    public String createNewProject(Projects employeeProjects, RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("message", employeeProjectsService.addEmployeeProject(employeeProjects));
        return "redirect:/manageEmployee";
    }

    /**
     * <p>
     *     returns to the home page of the application
     * </p>
     * @return home page (index.jsp)
     */
    @RequestMapping(value = "index")
    public String backToIndex() {
        return "index";
    }

    /**
     * <p>
     *     Home page of the application
     * </p>
     * @return home page (index.jsp)
     */
    @RequestMapping
    public String getIndex() {
        return "index";
    }

    /**
     * <p>
     *     mapping for employee page
     * </p>
     *
     * @return employee crud page
     */
    @RequestMapping(value="/employee")
    public String employeeCrud() {
        return "employee";
    }

    /**
     * <p>
     *     mapping for read employee page
     * </p>
     *
     * @return read employee page which shows all the employees
     */
    @RequestMapping(value = "/readEmployee")
    public String readEmployee() {
        return "readAllEmployees";
    }

    /**
     * <p>
     *     mapping for project page
     * </p>
     *
     * @return page which contains crud for employee project
     */
    @RequestMapping(value = "/projects")
    public String projectPage() {
        return "projects";
    }

    /**
     * <p>
     *     mapping for create employee page
     * </p>
     *
     * @return page which lets user create employee
     */
    @RequestMapping(value = "/createEmployee")
    public String createEmployee() {
        return "createEmployee";
    }

    /**
     * <p>
     *     mapping to manage employee page
     * </p>
     *
     * @return page which lets user manage employees
     */
    @RequestMapping(value = "/manageEmployee")
    public String manageEmployee() {
        return "manageEmployee";
    }

    /**
     * <p>
     *     mapping to modify employee
     * </p>
     *
     * @return page which lets user update, delete assign leave
     * records and employee projects
     */
    @RequestMapping(value = "/modifyEmployee")
    public String modifyEmployeePage() {
        return "modifyEmployee";
    }
}
