package com.apisw.config;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import com.apisw.DTO.AuthDTO;
import com.apisw.model.Post;
import com.apisw.model.User;
import com.apisw.repository.PostRepository;
import com.apisw.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Instantiation implements CommandLineRunner {

  @Autowired
  private UserRepository repository;

  @Autowired
  private PostRepository irepository;

  @Override
  public void run(String... args) throws Exception {

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

    repository.deleteAll();
    for (int i = 0; i <= 10; i++) {
      User rose = new User(null, "Rosemeire 001 "+ i, "rose@gmail.com");
      User rafa = new User(null, "Rafael 001 "+ i, "r@gmail.com");
      repository.save(rose);
      repository.save(rafa);
      irepository.save(new Post(null, dateFormat.parse("21/03/2020"), "Viajar -> " + i, "Fui para São Paulo qtd -> " + i, new AuthDTO(rose)));
    }
  }

  
}