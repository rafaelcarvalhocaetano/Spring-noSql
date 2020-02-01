package com.apisw.repository;

import com.apisw.model.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository
 */
@Repository
public interface UserRepository extends MongoRepository<User, String>{

  
}