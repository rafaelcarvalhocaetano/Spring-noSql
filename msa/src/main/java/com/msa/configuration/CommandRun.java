package com.msa.configuration;

import java.util.Arrays;

import com.msa.model.User;
import com.msa.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandRun implements CommandLineRunner {

  @Autowired
  private UserRepository repo;

  @Override
  public void run(String... args) throws Exception {
    

    repo.deleteAll();

    User maria = new User(null, "MARIA 1", "a@gmail.com1");
    User rafael = new User(null, "RAFA 1", "a@gmail.com1");
    User bob = new User(null, "BOB 1", "a@gmail.com1");

    repo.saveAll(Arrays.asList(maria, rafael, bob));

  }

  
}