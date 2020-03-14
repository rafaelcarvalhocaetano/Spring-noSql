package com.msa.configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import com.msa.dto.AuthorDTO;
import com.msa.dto.CommentDTO;
import com.msa.model.Post;
import com.msa.model.User;
import com.msa.repository.PostRepository;
import com.msa.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandRun implements CommandLineRunner {

  @Autowired
  private UserRepository user;

  @Autowired
  private PostRepository post;

  @Override
  public void run(String... args) throws Exception {

    
    SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
    data.setTimeZone(TimeZone.getTimeZone("GMT"));

    user.deleteAll();
    post.deleteAll();

    User maria = new User(null, "MARIA 1", "a@gmail.com1");
    User rafael = new User(null, "RAFA 1", "a@gmail.com1");
    User bob = new User(null, "BOB 1", "a@gmail.com1");

    user.saveAll(Arrays.asList(maria, rafael, bob));

    Post postOne = new Post(null, data.parse("21/03/2020"), "Partiu Viagem", "Vou viajar para São Paulo.", new AuthorDTO(maria));
    Post postTwo = new Post(null, data.parse("10/02/2019"), "Partiu Viagem", "Vou viajar para São Paulo.", new AuthorDTO(maria));

    CommentDTO cOne = new CommentDTO("Boa viagem", data.parse("13/03/2020"), new AuthorDTO(maria));
    CommentDTO cTwo = new CommentDTO("Boa viagem", data.parse("13/03/2020"), new AuthorDTO(rafael));
    CommentDTO cThree = new CommentDTO("Boa viagem", data.parse("13/03/2020"), new AuthorDTO(maria));
    CommentDTO cFour = new CommentDTO("Boa viagem", data.parse("13/03/2020"), new AuthorDTO(bob));

    postOne.getCommentDTOs().addAll(Arrays.asList(cOne, cTwo));
    postTwo.getCommentDTOs().addAll(Arrays.asList(cThree, cFour));

    post.saveAll(Arrays.asList(postOne, postTwo));

    maria.getPosts().addAll(Arrays.asList(postOne, postTwo));
    user.save(maria);

  }

  
}