package com.management.user.services;

import java.util.List;
import java.util.Optional;

import com.management.user.model.User;
import com.management.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository repository;


  public Iterable<User> getAllUsers() {
    return repository.findAll();
  }

  public User create(User user) {
    return repository.save(user);
  }

  public Optional<User> getId(Long id) {
    Optional<User> user = repository.findById(id);
    return user;
  }


  public User update(User user) {
    Optional<User> userId = repository.findById(user.getId());
    if (userId != null) {
      return repository.save(user);
    }
    return null;
  }

  public boolean delete(Long id) {
    if (id != null) {
      repository.deleteById(id);
      return true;
    }
    return false;
  }

  public User getUserName(String name) {
    return repository.findByUsername(name);
  }
  
}