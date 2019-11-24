package com.api.mocks;

import java.util.ArrayList;
import java.util.List;

import com.api.model.Person;
import com.api.vo.PersonVO;

public class MockPerson {

  public Person mockEntity() {
    return mockEntity(0);
  }

  public PersonVO mockVO() {
    return mockVO(0);
  }

  public List<Person> mockEntityList() {
    List<Person> persons = new ArrayList<Person>();
    for (int i = 0; i < 14; i++) {
      persons.add(mockEntity(i));
    }
    return persons;
  }

  public List<PersonVO> mockVOList() {
    List<PersonVO> persons = new ArrayList<>();
    for (int i = 0; i < 14; i++) {
      persons.add(mockVO(i));
    }
    return persons;
  }

  private Person mockEntity(Integer number) {
    Person person = new Person();
    person.setAddress("Address Test " + number);
    person.setFirstName("First " + number);
    person.setLastName("Last " + number);
    person.setGender("GENDER " + number);
    person.setId(number);
    return person;
  }

  private PersonVO mockVO(Integer number) {
    PersonVO person = new PersonVO();
    person.setAddress("Address Test " + number);
    person.setFirstName("First " + number);
    person.setLastName("Last " + number);
    person.setGender("GENDER " + number);
    person.setId(number);
    return person;
  }

  
}