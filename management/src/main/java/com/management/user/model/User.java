package com.management.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "MNG_USER", schema = "usermanagement")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "USER_NAME", length=50, nullable=false, unique=true)
  private String username;

  @Column(name = "FIRST_NAME", length = 50, nullable = false)
  private String firtname;
  
  @Column(name = "LAST_NAME", length = 50, nullable = false)
  private String lastname;

  @Column(name = "EMAIL", length = 50, nullable = false)
  private String email;

  @Column(name = "ROLE", length = 50, nullable = false)
  private String role;

  @Column(name = "SSN", length=50, nullable=false)
  private String ssn;

  public User() {
  }

  public User(Long id, String username, String firtname, String lastname, String email, String role, String ssn) {
    this.id = id;
    this.username = username;
    this.firtname = firtname;
    this.lastname = lastname;
    this.email = email;
    this.role = role;
    this.ssn = ssn;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getFirtname() {
    return firtname;
  }

  public void setFirtname(String firtname) {
    this.firtname = firtname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getSsn() {
    return ssn;
  }

  public void setSsn(String ssn) {
    this.ssn = ssn;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
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
    User other = (User) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    return "User [email=" + email + ", firtname=" + firtname + ", id=" + id + ", lastname=" + lastname + ", role="
        + role + ", ssn=" + ssn + ", username=" + username + "]";
  }
  
}