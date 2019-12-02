package com.management.user.exceptions;


public class UserNotNameException extends Exception {

  private static final long serialVersionUID = 1L;

  public UserNotNameException(String messageName) {
    super(messageName);
  }

  
}