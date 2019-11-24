package com.api.controller;

import com.api.model.Person;
import com.api.service.PersonService;
import com.api.vo.PersonVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

  @Autowired
  private PersonService personService;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<PersonVO> get() {
    return personService.findAll();
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public PersonVO getId(@PathVariable("id") Integer id) {
    return personService.findById(id);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public PersonVO save(@RequestBody PersonVO p) {
    return personService.createPerson(p);
  }

  @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public PersonVO updatePerson(@RequestBody PersonVO p) {
    return personService.update(p);
  }

  @DeleteMapping(value = "/{id}")
  public void delete(@PathVariable("id") Integer id) {
    personService.delete(id);
  }


}