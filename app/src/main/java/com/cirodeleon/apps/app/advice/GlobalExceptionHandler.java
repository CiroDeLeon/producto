package com.cirodeleon.apps.app.advice;

import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleException(Exception e) {   
    	e.printStackTrace();
        return new ResponseEntity<>(Collections.singletonMap("mensaje", e.getMessage()), HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        
        String errorMessage = ex.getBindingResult().getAllErrors().stream()
            .map(error -> {
                String fieldName = ((FieldError) error).getField();
                String message = error.getDefaultMessage();
                return fieldName + ": " + message;
            })
            .collect(Collectors.joining(", "));

       
        return new ResponseEntity<>(Collections.singletonMap("message", errorMessage), HttpStatus.BAD_REQUEST);
    }
}