package com.msa.dto;

import java.util.Date;

public class CommentDTO {

  
  private String text;
  private Date date;
  private AuthorDTO authorDTO;

  public CommentDTO() {
  }

  public CommentDTO(String text, Date date, AuthorDTO authorDTO) {
    this.text = text;
    this.date = date;
    this.authorDTO = authorDTO;
  }

  /**
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * @return the date
   */
  public Date getDate() {
    return date;
  }

  /**
   * @return the authorDTO
   */
  public AuthorDTO getAuthorDTO() {
    return authorDTO;
  }

  /**
   * @param text the text to set
   */
  public void setText(String text) {
    this.text = text;
  }

  /**
   * @param date the date to set
   */
  public void setDate(Date date) {
    this.date = date;
  }

  /**
   * @param authorDTO the authorDTO to set
   */
  public void setAuthorDTO(AuthorDTO authorDTO) {
    this.authorDTO = authorDTO;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((authorDTO == null) ? 0 : authorDTO.hashCode());
    result = prime * result + ((date == null) ? 0 : date.hashCode());
    result = prime * result + ((text == null) ? 0 : text.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CommentDTO other = (CommentDTO) obj;
    if (authorDTO == null) {
      if (other.authorDTO != null)
        return false;
    } else if (!authorDTO.equals(other.authorDTO))
      return false;
    if (date == null) {
      if (other.date != null)
        return false;
    } else if (!date.equals(other.date))
      return false;
    if (text == null) {
      if (other.text != null)
        return false;
    } else if (!text.equals(other.text))
      return false;
    return true;
  }

  
}