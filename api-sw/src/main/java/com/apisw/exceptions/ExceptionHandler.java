package com.apisw.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.apisw.exceptions.UserException;

@ControllerAdvice
public class ExceptionHandler {


  @ExceptionHandler(UserException.class)
  public ResponseEntity<StandardError> objectNotFound(UserException e, HttpServletRequest http) {

    final HttpStatus status = HttpStatus.NOT_FOUND;
    final StandardError error = new StandardError(System.currentTimeMillis(), status.value(), "Não Encontrado", e.getMessage(), http.getRequestURI());
    return ResponseEntity.status(status).body(error);
  
  }

  
}