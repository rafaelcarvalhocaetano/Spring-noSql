package com.apisw.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
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
  private UserRepository userRepository;

  @Autowired
  private PostRepository postRepository;

  @Override
  public void run(final String... args) throws Exception {

    final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

    User rose = new User();
    User rafa = new User();
    Post rosePost = new Post();
    Post rafaPost = new Post();    
    userRepository.deleteAll();
    postRepository.deleteAll();
    
    for (int i = 0; i <= 10; i++) {
      rose = new User(null, "Rosemeire 001 "+ i, "rose@gmail.com");
      rafa = new User(null, "Rafael 001 "+ i, "r@gmail.com");
      rosePost = new Post(null, dateFormat.parse("21/03/2020"), "Viajar -> " + i, "Fui para São Paulo qtd -> " + i, new AuthDTO(rose));
      rafaPost = new Post(null, dateFormat.parse("21/03/2020"), "Viajar -> " + i, "Fui para São Paulo qtd -> " + i, new AuthDTO(rafa));
    
      userRepository.save(rose);
      postRepository.save(rafaPost);
      userRepository.save(rafa);
      postRepository.save(rosePost);

      rose.getPosts().addAll(Arrays.asList(rosePost));
      rafa.getPosts().addAll(Arrays.asList(rafaPost));

      userRepository.save(rose);

    }



    
  }

  
}