package com.example.demo.controller.ResourceException;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.service.ResourcesException.DataBaseException;
import com.example.demo.service.ResourcesException.ResourcePriorityException;
import com.example.demo.service.ResourcesException.ResourceStatusException;
import com.example.demo.service.ResourcesException.ResourcesDeadlineException;
import com.example.demo.service.ResourcesException.ResourcesNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourcesExceptionHandler {

    @ExceptionHandler(ResourcesNotFoundException.class)
    public ResponseEntity<StandardException> resourceExcepiton(ResourcesNotFoundException e,
            HttpServletRequest request) {
        String error = "Resources Not Found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardException err = new StandardException(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ResourcesDeadlineException.class)
    public ResponseEntity<StandardException> resourceExcepiton(ResourcesDeadlineException e,
            HttpServletRequest request) {
        String error = "Resources Not Found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardException err = new StandardException(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ResourcePriorityException.class)
    public ResponseEntity<StandardException> resourceExcepiton(ResourcePriorityException e,
            HttpServletRequest request) {
        String error = "Resources Not Found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardException err = new StandardException(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ResourceStatusException.class)
    public ResponseEntity<StandardException> resourceExcepiton(ResourceStatusException e,
            HttpServletRequest request) {
        String error = "Resources Not Found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardException err = new StandardException(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandardException> resourcesException(DataBaseException e, HttpServletRequest request) {
        String error = "Database Error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardException err = new StandardException(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}