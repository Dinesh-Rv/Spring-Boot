package com.ideas2it.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * ExceptionMessage.java
 *
 * <p> Contains model attributes for Exception message
 * can be used for multiple exception types, doesn't contain
 * any input or output operations
 * </p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionMessage {
    private HttpStatus status;
    private String message;
}
