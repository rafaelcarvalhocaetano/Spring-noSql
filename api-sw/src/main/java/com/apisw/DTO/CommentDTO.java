package com.apisw.DTO;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable {


  private static final long serialVersionUID = 1L;
  private String text;
  private Date date;
  private AuthDTO author;

  public CommentDTO() {
  }

  public CommentDTO(String text, Date date, AuthDTO author) {
    this.text = text;
    this.date = date;
    this.author = author;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public AuthDTO getAuthor() {
    return author;
  }

  public void setAuthor(AuthDTO author) {
    this.author = author;
  }
  
  
}