package com.api.converter;

import java.util.List;

import com.api.mocks.MockPerson;
import com.api.vo.PersonVO;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConverterTest {

  MockPerson mock;

  @Before
  public void description() {
    mock = new MockPerson();
  }

  @Test
  public void parseEntityVOTest() {
    PersonVO output = DozerConverter.parseObject(mock, PersonVO.class);
    Assert.assertEquals(Long.valueOf(0), output.getId());
    Assert.assertEquals("First Name Test0", output.getFirstName());
  }

  @Test
  public void parseEntityTestListToVOListTest() {
    List<PersonVO> output = DozerConverter.parseListObject(mock.mockEntityList(), PersonVO.class);
    PersonVO out =  output.get(0);
    Assert.assertEquals(Long.valueOf(0), out.getId());
    Assert.assertEquals("First Name Test0", out.getFirstName());
  }
  
}