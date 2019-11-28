package com.address.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "adr_address")
public class Address extends Chips {

  private City city = new City();
  private State state = new State();

  
}