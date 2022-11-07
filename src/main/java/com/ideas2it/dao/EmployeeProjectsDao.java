package com.ideas2it.dao;
import com.ideas2it.model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * EmployeeProjectsDao.java
 * <p>
 * Interface that acts as a data access for the employee Projects
 * </p>
 * @author Dinesh Ravikumar
 * @since  at 07/11/2022
 */
public interface EmployeeProjectsDao extends JpaRepository<Projects, Integer> {

}