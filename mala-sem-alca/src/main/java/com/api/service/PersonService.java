package com.api.service;

import com.api.exceptions.ResourceNotFoundException;
import com.api.model.Person;
import com.api.repository.PersonRepository;
import com.api.model.IPerson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PersonService implements IPerson {

  @Autowired
  private PersonRepository repository;

  @Override
  public Person createPerson(Person person) {
    return repository.save(person);
  }

  @Override
  public void delete(Integer id) {
    Person p = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("SEM ID"));
    repository.delete(p);
  }

  @Override
  public Iterable<Person> findAll() {
    return repository.findAll();
  }

  @Override
  public Person findById(Integer id) {
    return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Erro na bagaça"));
  }

  @Override
  public Person update(Person person) {
    return repository.save(person);
  }
  
}