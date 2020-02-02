package com.apisw.DTO;

import java.io.Serializable;

import com.apisw.model.User;

public class AuthDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String id;
  private String name;

  public AuthDTO() {
  }

  public AuthDTO(User user) {
    id = user.getId();
    name = user.getName();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  
  
}