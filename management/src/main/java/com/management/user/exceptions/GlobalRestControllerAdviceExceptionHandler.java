package com.management.user.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// @RestControllerAdvice
public class GlobalRestControllerAdviceExceptionHandler {

  @ExceptionHandler(UserNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public CustomErrorDetails userNotNameFound(UserNotNameException ex) {
    return new CustomErrorDetails(new Date(), "From @RestControllerAdvice NOT FOUND", ex.getMessage());
  }
  
}