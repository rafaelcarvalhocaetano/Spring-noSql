package com.msa.controller;

import com.msa.model.Post;
import com.msa.services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/post")
public class PostController {


  @Autowired
  private PostService postService;

  @GetMapping(value = "/{id}")
  public ResponseEntity<Post> findId(@PathVariable("id") String id) {
    Post post = postService.findById(id);
    return ResponseEntity.ok().body(post);
  }
  
}