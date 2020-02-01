package com.apisw.service;

import java.util.List;
import java.util.Optional;

import com.apisw.exceptions.UserException;
import com.apisw.model.User;
import com.apisw.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserService
 */
@Service
public class UserService {

  @Autowired
  private UserRepository repository;

  public List<User> findAll() {
    return repository.findAll();
  }

  public User findById(String id) {
    Optional<User> userId = repository.findById(id);
    return userId.orElseThrow(() -> new UserException("User not found"));
  }
  
}