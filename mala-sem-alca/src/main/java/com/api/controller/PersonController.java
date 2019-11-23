package com.api.controller;

import com.api.model.Person;
import com.api.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PersonController
 */
@RestController
@RequestMapping(value = "/person")
public class PersonController {

  @Autowired
  private PersonService ps;

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Person findById(@PathVariable("id") String id) {
    return ps.findById(id);
  }

}