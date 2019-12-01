package com.management.user.controller;

import java.util.Optional;

import com.management.user.exceptions.UserNotFoundException;
import com.management.user.model.User;
import com.management.user.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/user")
public class UserController {

  private final String JSON = "application/json";

  @Autowired
  private UserService userService;


  @GetMapping(produces={JSON})
  public Iterable<User> get() {
    return userService.getAllUsers();
  }

  @GetMapping(value = "/{id}")
  public Optional<User> getId(@PathVariable("id") Long id) {
    try {
      return userService.getId(id);
    } catch (UserNotFoundException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    }
  }

  @GetMapping(value = "/name/{name}")
  public User getUserName(@PathVariable("name") String name) {
    try {
      return userService.getUserName(name);
    } catch (UserNotFoundException e) {
      new UserNotFoundException("Mais de um Item");
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    }
  }

  @PostMapping(consumes = {JSON}, produces = {JSON})
  public User createUser(@RequestBody User user) {
    System.out.println(user);
    return userService.create(user);
  }

  @PutMapping(consumes = {JSON}, produces = {JSON})
  public User updateUser(@RequestBody User user) {
    return userService.update(user);
  }

  @DeleteMapping(value = "/{id}", consumes = {JSON}, produces = {JSON})
  public boolean deleteUser(@PathVariable("id") Long id) {
    return userService.delete(id);
  }
}