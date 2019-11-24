package com.api.controller;

import com.api.service.PersonService;
import com.api.vo.PersonVO;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/person/v1")
public class PersonController {

  private final String JSON = "application/json";
  private final String XML = "application/xml";
  private final String YML = "application/x-yaml";

  @Autowired
  private PersonService personService;

  @GetMapping(produces = { JSON, XML, YML })
  public Iterable<PersonVO> get() {
    return personService.findAll();
  }



  @GetMapping(value = "/{id}", produces = { JSON, XML, YML })
  public PersonVO getId(@PathVariable("id") Integer id) {
    return personService.findById(id);
  }

  @PostMapping(consumes = { JSON, XML, YML }, produces = { JSON, XML, YML})
  public PersonVO save(@RequestBody PersonVO p) {
    return personService.createPerson(p);
  }

  @PutMapping(consumes = { JSON, XML, YML }, produces = { JSON, XML, YML })
  public PersonVO updatePerson(@RequestBody PersonVO p) {
    System.out.println(p);
    return personService.update(p);
  }


  @DeleteMapping(value = "/{id}")
  public void delete(@PathVariable("id") Integer id) {
    personService.delete(id);
  }


}