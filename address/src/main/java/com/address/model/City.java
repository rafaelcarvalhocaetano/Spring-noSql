package com.address.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "adr_city")
public class City extends Chips {

  private String zone;

  private State state;

}
