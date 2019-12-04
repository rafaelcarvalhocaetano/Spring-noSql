package com.management.user.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotEmpty(message = "User Name is Mandatory field. Please provide user name")
  @Column(name = "USER_NAME", length=50, nullable=false)
  private String username;

  @Size(min = 2, message = "First Name should have atleast 2 characters")
  @Column(name = "FIRST_NAME", length = 50, nullable = false)
  private String firstname;
  
  @Column(name = "LAST_NAME", length = 50, nullable = false)
  private String lastname;

  @Column(name = "EMAIL", length = 50, nullable = false)
  private String email;

  @Column(name = "ROLE", length = 50, nullable = false)
  private String role;

  @Column(name = "SSN", length=50, nullable=false)
  private String ssn;

  @OneToMany
  private List<Order> orders = new ArrayList<>();

  public User() { }

  public User(Long id, String username, String firtname, String lastname, String email, String role, String ssn) {
    this.id = id;
    this.username = username;
    this.firstname = firtname;
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
    return firstname;
  }

  public void setFirtname(String firtname) {
    this.firstname = firtname;
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

  public List<Order> getOrder() {
    return orders;
  }

  public void setOrder(List<Order> order) {
    this.orders = order;
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
    return "User [email=" + email + ", firstname=" + firstname + ", id=" + id + ", lastname=" + lastname + ", role="
        + role + ", ssn=" + ssn + ", username=" + username + "]";
  }
  
}