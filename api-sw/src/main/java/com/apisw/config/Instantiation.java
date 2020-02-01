package com.apisw.config;

import com.apisw.model.User;
import com.apisw.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 * Instantiation
 */
@Configuration
public class Instantiation implements CommandLineRunner {

  @Autowired
  private UserRepository repository;

  @Override
  public void run(String... args) throws Exception {
    repository.deleteAll();
    for (int i = 0; i <= 10; i++) {
      repository.save(new User(null, "Rafael 001 "+ i, "r@gmail.com"));
    }
  }

  
}