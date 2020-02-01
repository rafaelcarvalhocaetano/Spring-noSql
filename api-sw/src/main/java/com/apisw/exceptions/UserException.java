package com.apisw.exceptions;


public class UserException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public UserException(String msn) {
    super(msn);
  }

}