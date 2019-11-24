package com.api.model;

import com.api.vo.PersonVO;

public interface IPerson {

  public PersonVO createPerson(PersonVO person);
  public void delete(Integer id);
  public PersonVO update(PersonVO PersonVO);
  public Iterable<PersonVO> findAll();
  public PersonVO findById(Integer id);
}