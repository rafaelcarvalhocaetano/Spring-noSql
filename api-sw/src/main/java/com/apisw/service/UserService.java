package com.apisw.service;

import java.util.List;
import java.util.Optional;

import com.apisw.DTO.UserDTO;
import com.apisw.exceptions.UserException;
import com.apisw.model.User;
import com.apisw.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository repository;

  public List<User> findAll() {
    return repository.findAll();
  }

  public User findById(final String id) {
    final Optional<User> userId = repository.findById(id);
    return userId.orElseThrow(() -> new UserException("User not found"));
  }

  public User insert(final User user) {
    return repository.insert(user);
  }

  public User frontDTO(final UserDTO dto) {
    return new User(dto.getId(), dto.getName(), dto.getEmail());
  }

  public void delete(final String id) {
    final Optional<User> userId = repository.findById(id);
    userId.orElseThrow(() -> new UserException("User not found"));
    repository.deleteById(id);
  }

  public User update(User user) {
    return repository.insert(user);
  }
  
}