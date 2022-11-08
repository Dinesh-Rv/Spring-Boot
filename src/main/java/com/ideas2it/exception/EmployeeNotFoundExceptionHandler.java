package com.ideas2it.exception;

import com.ideas2it.model.ExceptionMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class EmployeeNotFoundExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ExceptionMessage> employeeNotFoundException(EmployeeNotFoundException exception,
                                                                     WebRequest request) {
        ExceptionMessage message = new ExceptionMessage(HttpStatus.NOT_FOUND,
                exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
