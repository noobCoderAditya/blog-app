package com.boobCoder.blog.config;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> handleDataIntegrityViolation(DataIntegrityViolationException ex){
        String message = """
                {
                    Error: "Duplicate Key Constraint"
                }
                """;
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
