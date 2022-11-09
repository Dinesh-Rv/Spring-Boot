package com.ideas2it.exception;

import com.ideas2it.model.ExceptionMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * EmployeeNotFoundExceptionHandler.java
 *
 * <p>
 *     Fetches the Custom exception(EmployeeNotFoundException)
 *     and Handles it by sending a message as a response
 * </p>
 * @author Dinesh Rv
 * @since 08/11/2022
 */
@ControllerAdvice
@ResponseStatus
public class NotFoundExceptionHandler
        extends ResponseEntityExceptionHandler {

    /**
     * <p>
     *     Fetches the EmployeeNotFoundException and instead of a error message
     *     sends it as a response(Handling the exception)
     * </p>
     * @param exception
     *        Contains the exception throwed
     *
     * @return the response message for exception with message
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionMessage> employeeNotFoundException(NotFoundException exception) {
        ExceptionMessage message = new ExceptionMessage(HttpStatus.NOT_FOUND,
                exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
