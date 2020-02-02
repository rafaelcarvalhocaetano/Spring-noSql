package com.apisw.service;

import java.util.Date;
import java.util.Optional;
import com.apisw.exceptions.UserException;
import com.apisw.model.Post;
import com.apisw.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

  @Autowired
  private PostRepository repository;

  public Post findById(final String id) {
    final Optional<Post> userId = repository.findById(id);
    return userId.orElseThrow(() -> new UserException("Post not found"));
  }

  public Iterable<Post> findByTitle(String text) {
    return repository.searchTitle(text);
  }

  public Iterable<Post> fullSearch(String text, Date minDate, Date maxDate) {
    maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
    return repository.fullSearch(text, minDate, maxDate);
  }
  
}