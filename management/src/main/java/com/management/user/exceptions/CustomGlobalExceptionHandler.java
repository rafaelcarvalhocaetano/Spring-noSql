package com.management.user.exceptions;

import java.util.Date;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid (
    MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request
  ) {
    CustomErrorDetails details = new CustomErrorDetails(
      new Date(), 
      "ERROR 0001",
      ex.getMessage()
      );
    return new ResponseEntity<Object>(details, HttpStatus.BAD_REQUEST);
  }

  @Override
  protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
    HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status,
    WebRequest request
  ) {
    CustomErrorDetails details = new CustomErrorDetails(
      new Date(), 
      "GET ERRO 00002",
      ex.getMessage()
      );
      return new ResponseEntity<Object>(details, HttpStatus.METHOD_NOT_ALLOWED);
  }

  // not user name
  @ExceptionHandler(UserNotNameException.class)
  public final ResponseEntity<Object>  handlerUserNameNotFountException(
    UserNotNameException ex, WebRequest request) {
      CustomErrorDetails details = new CustomErrorDetails(
        new Date(), ex.getMessage(), request.getDescription(false)
      );
      return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public final ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex, WebRequest wq) {
    CustomErrorDetails dt = new CustomErrorDetails(new Date(), ex.getMessage(), wq.getDescription(false));
    return new ResponseEntity<>(dt, HttpStatus.BAD_REQUEST);
  }

}