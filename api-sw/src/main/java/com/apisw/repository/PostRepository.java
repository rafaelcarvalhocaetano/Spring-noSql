package com.apisw.repository;

import java.util.List;

import com.apisw.model.Post;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends MongoRepository<Post, String>{

  List<Post> findByTitleContainingIgnoreCase(String text);
  
}