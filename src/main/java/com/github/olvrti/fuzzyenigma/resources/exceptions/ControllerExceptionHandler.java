package com.github.olvrti.fuzzyenigma.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import com.github.olvrti.fuzzyenigma.services.exceptions.ObjectNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(ObjectNotFoundException.class)
  public ResponseEntity<String> objectNotFound(final ObjectNotFoundException exception,
      final HttpServletRequest request) {
    final StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Not found",
        exception.getMessage(), request.getRequestURI());

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
  }
}