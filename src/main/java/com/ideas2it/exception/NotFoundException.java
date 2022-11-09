package com.ideas2it.exception;

/**
 * EmployeeNotFoundException.java
 *
 * <p>
 *     Defined an Custom exception.
 *     Exception in which it occurs if there's an error
 *     while searching or getting an employee.
 * </p>
 *
 * @author Dinesh Rv
 * @since 08/11/2022
 */
public class EmployeeNotFoundException extends Exception{

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
