package com.apisw.repository;

import com.apisw.model.Post;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository
 */
@Repository
public interface PostRepository extends MongoRepository<Post, String>{

  
}