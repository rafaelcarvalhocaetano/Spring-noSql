package com.address.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "adr_address")
public class Address extends Chips {

  private String rua;

  
}