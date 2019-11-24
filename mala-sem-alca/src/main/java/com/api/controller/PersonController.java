package com.api.controller;

import com.api.service.PersonService;
import com.api.vo.PersonVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/person/v1")
public class PersonController {

  private final String JSON = "application/json";
  private final String XML = "application/xml";
  private final String YML = "application/x-yaml";

  @Autowired
  private PersonService personService;

  @GetMapping(produces = { JSON, XML, YML })
  public ResponseEntity<Page<PersonVO>> get(
          @RequestParam(value = "page", defaultValue = "0") int page,
          @RequestParam(value = "limit", defaultValue = "12") int limit,
          @RequestParam(value = "direction", defaultValue = "asc") String direction
  ) {

    Sort.Direction desc = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;
    Pageable pageable = PageRequest.of(page, limit, Sort.by(desc));
    Page<PersonVO> persons = personService.findAll(pageable);

    return new ResponseEntity<>(persons, HttpStatus.OK);
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