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
public class NotFoundException extends Exception{

    public NotFoundException(String message) {
        super(message);
    }
}
