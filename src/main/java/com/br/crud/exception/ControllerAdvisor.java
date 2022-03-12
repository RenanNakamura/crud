package com.br.crud.exception;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    private static final String BODY_TIME = "timestamp";
    private static final String BODY_MESSAGE = "message";

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException e, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();

        body.put(BODY_TIME, LocalDateTime.now());
        var index = new AtomicInteger();
        e.getConstraintViolations().forEach(c -> body.put(BODY_MESSAGE + index.incrementAndGet(), c.getMessage()));

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException e, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();

        body.put(BODY_TIME, LocalDateTime.now());
        body.put(BODY_MESSAGE, e.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(SQLIntegrityConstraintViolationException e, WebRequest re) {
        Map<String, Object> body = new LinkedHashMap<>();

        body.put(BODY_TIME, LocalDateTime.now());
        body.put(BODY_MESSAGE, e.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_IMPLEMENTED);
    }

}
