package com.api.model;

import com.api.model.Person;

public interface IPerson {

  public Person createPerson(Person person);
  public void delete(Integer id);
  public Person update(Person person);
  public Iterable<Person> findAll();
  public Person findById(Integer id);
}