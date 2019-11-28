package com.address.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "adr_state")
public class State extends Chips {
  
  @ManyToOne
  private City citys;
}
