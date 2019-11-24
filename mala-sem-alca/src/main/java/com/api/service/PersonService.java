package com.api.service;

import com.api.converter.DozerConverter;
import com.api.exceptions.ResourceNotFoundException;
import com.api.model.Person;
import com.api.repository.PersonRepository;
import com.api.vo.PersonVO;
import com.api.model.IPerson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonService implements IPerson {

  @Autowired
  private PersonRepository repository;

  @Override
  public PersonVO createPerson(PersonVO person) {
    Person p = DozerConverter.parseObject(person, Person.class);
    PersonVO po = DozerConverter.parseObject(repository.save(p), PersonVO.class);
    return po;
  }

  @Override
  public void delete(Integer id) {
    Person p = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("SEM ID"));
    repository.delete(p);
  }

  @Override
  public Iterable<PersonVO> findAll() {
    return DozerConverter.parseListObject(repository.findAll(), PersonVO.class);
  }

  @Override
  public PersonVO findById(Integer id) {
    Person p = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Erro na bagaça"));
    return DozerConverter.parseObject(p, PersonVO.class);
  }

  @Override
  public PersonVO update(PersonVO person) {
    Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Erro na bagaça"));
    System.out.println(entity);
    return DozerConverter.parseObject(repository.save(entity), PersonVO.class);
  }

    public Page<PersonVO> findAll(Pageable pageable) {
      List<Person> entities = repository.findAll(pageable).getContent();
      // Pageable entities = repository.findAll(pageable);
      return (Page) DozerConverter.parseListObject(entities, PersonVO.class);
      // return entities.map(this::covertToPersonVO);
    }

    private PersonVO covertToPersonVO(Person pd) {
      return DozerConverter.parseObject(pd, PersonVO.class);
    }
}