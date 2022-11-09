package com.ideas2it.service;

import com.ideas2it.model.Projects;
import com.ideas2it.dao.EmployeeProjectsDao;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeProjectsServiceImpl implements EmployeeProjectsService {

    private final EmployeeProjectsDao employeeProjectsDao;

    public EmployeeProjectsServiceImpl(EmployeeProjectsDao employeeProjectsDao) {
        this.employeeProjectsDao = employeeProjectsDao;
    }
    public boolean addEmployeeProject(Projects record) {
        return true;//return employeeProjectsDao.addEmployeeProject(record);
    }

    public List<Projects> getAllProjects() {
        return null;
        //return employeeProjectsDao.getAllEmployeeProjects();
    }

    public List<Projects> getEmployeeProject(String employeeId) {
        return null;
        //return employeeProjectsDao.getEmployeeProject(employeeId);
    }

    public boolean updateEmployeeProjects(Projects projects) {
        return true;
         //return employeeProjectsDao.updateEmployeeProjects(projects);
    }


}