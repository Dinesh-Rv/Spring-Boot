package com.ideas2it.dao;
import com.ideas2it.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * EmployeeDao.java
 * <p>
 * Interface that acts as a data access for the Employee Crud operations
 * </p>
 * @author Dinesh Ravikumar
 * @since 07/11/2022
 */
@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}