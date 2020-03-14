package com.msa.services;

import java.util.Optional;

import com.msa.exceptions.UserExceptions;
import com.msa.model.Post;
import com.msa.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {


  @Autowired
  private PostRepository postRepository;


  public Post findById(String id) {
    Optional<Post> post = postRepository.findById(id);
   return post.orElseThrow(() -> new UserExceptions("Post não encontrado"));
  }
  
}