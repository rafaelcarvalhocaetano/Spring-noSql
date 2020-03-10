package com.msa.exceptions;

public class UserExceptions extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public UserExceptions(String name) {
    super(name);
  }
  
}