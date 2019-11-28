package com.address.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "adr_country")
public class Country extends Chips {

  @ManyToOne
  private State states;
}