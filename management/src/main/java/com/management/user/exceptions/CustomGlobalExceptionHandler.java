package com.management.user.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
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
      "ERRO BLABLABLAAAAAA",
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
      "GET ERRO BLABLABLABLA",
      ex.getMessage()
      );
      return new ResponseEntity<Object>(details, HttpStatus.METHOD_NOT_ALLOWED);
  }
}