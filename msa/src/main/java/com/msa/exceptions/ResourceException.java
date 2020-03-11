package com.msa.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceException {

  @ExceptionHandler(ObjectNotFoundException.class)
  public ResponseEntity<StandardError> objNotFound(ObjectNotFoundException e, HttpServletRequest http) {
    HttpStatus status = HttpStatus.NOT_FOUND;
    StandardError error = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), http.getRequestURI());
    return ResponseEntity.status(status).body(error);
  }
  
}