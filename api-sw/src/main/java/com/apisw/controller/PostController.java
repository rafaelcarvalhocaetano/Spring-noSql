package com.apisw.controller;

import com.apisw.model.Post;
import com.apisw.service.PostService;
import com.apisw.util.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/post")
public class PostController {

  @Autowired
  private PostService service;

  @GetMapping(value = "/{id}")
  public ResponseEntity<Post> findAll(@PathVariable("id") String id) {
    Post listPost = service.findById(id);
    return ResponseEntity.ok().body(listPost);    
  }


  @GetMapping(value = "/titlesearch")
  public ResponseEntity<Iterable<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
    text = URL.decodeParam(text);
    Iterable<Post> list = service.findByTitle(text);
    return ResponseEntity.ok().body(list);    
  }

  
}