package com.management.user.model;

import java.io.Serializable;
import com.management.user.model.User;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Order implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String orderDescription;

  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnore
  private User user;

  public Order() {
  }

  public Order(Long orderId, String orderDescription, User user) {
    this.id = orderId;
    this.orderDescription = orderDescription;
    this.user = user;
  }

  public Long getOrderId() {
    return id;
  }

  public void setOrderId(Long orderId) {
    this.id = orderId;
  }

  public String getOrderDescription() {
    return orderDescription;
  }

  public void setOrderDescription(String orderDescription) {
    this.orderDescription = orderDescription;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
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
    Order other = (Order) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Order [orderDescription=" + orderDescription + ", orderId=" + id + ", user=" + user + "]";
  }
  
}