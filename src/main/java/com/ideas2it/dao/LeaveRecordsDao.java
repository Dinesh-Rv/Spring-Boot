package com.ideas2it.dao;
import com.ideas2it.model.LeaveRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * LeaveRecordsDao.java
 * <p>
 * Interface that acts as a data access for the Leave Records for the employee
 * </p>
 * @author Dinesh Ravikumar
 * @since 07/11/2022
 */
@Repository
public interface LeaveRecordsDao extends JpaRepository<LeaveRecords, Integer> {

}
