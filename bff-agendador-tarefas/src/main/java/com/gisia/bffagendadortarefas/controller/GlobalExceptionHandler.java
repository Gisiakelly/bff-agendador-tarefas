package com.gisia.bffagendadortarefas.controller;

import com.gisia.bffagendadortarefas.infrastructure.exceptions.ConflictException;
import com.gisia.bffagendadortarefas.infrastructure.exceptions.IllegalArgumentException;
import com.gisia.bffagendadortarefas.infrastructure.exceptions.ResourceNotFoundException;
import com.gisia.bffagendadortarefas.infrastructure.exceptions.UnauthorizedExeception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleException(ResourceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<String> handleConflictException(ConflictException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UnauthorizedExeception.class)
    public ResponseEntity<String> handleUnauthorizedExeception(UnauthorizedExeception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
