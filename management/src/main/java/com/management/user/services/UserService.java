package com.management.user.services;

import java.util.Optional;

import com.management.user.exceptions.UserExceptions;
import com.management.user.exceptions.UserNotFoundException;
import com.management.user.model.User;
import com.management.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

  @Autowired
  private UserRepository repository;


  public Iterable<User> getAllUsers() {
    return repository.findAll();
  }

  public User create(User user) throws UserExceptions {
    User userExistent = repository.findByUsername(user.getUsername());
    if (userExistent != null) {
      throw new UserExceptions("User exists in database");
    }
    return repository.save(user);
  }

  public Optional<User> getId(Long id) throws UserNotFoundException {
    Optional<User> user = repository.findById(id);

    if (!user.isPresent()) {
      throw new UserNotFoundException("Erro ao carregar");
    }
    return user;
  }


  public User update(User user) throws UserExceptions {
    Optional<User> userId = repository.findById(user.getId());
    if (!userId.isPresent()) {
      throw new UserExceptions("User not found in user repository");
    }
    return repository.save(user);
  }

  public void delete(Long id) {
    Optional<User> userID = repository.findById(id);
    if (!userID.isPresent()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao tentar deletar arquivo");
    } else {
      repository.deleteById(id);
    }
  }

  public User getUserName(String name) throws UserNotFoundException {
    return repository.findByUsername(name);
  }
  
}