package com.api.service;

import java.util.concurrent.atomic.AtomicInteger;

import com.api.model.Person;

import org.springframework.stereotype.Service;

/**
 * PersonService
 */
@Service
public class PersonService {

  private final AtomicInteger count = new AtomicInteger();

  public Person findById(String id) {
    Person p = new Person();
    p.setId(count.incrementAndGet());
    p.setFirstName("Rafael");
    p.setLastName("CC");
    p.setAddress("Rua");
    p.setGender("M");
    return p;
  }
  
}