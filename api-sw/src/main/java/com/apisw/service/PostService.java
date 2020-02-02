package com.apisw.service;

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
  
}