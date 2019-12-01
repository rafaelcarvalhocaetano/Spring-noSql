package com.management.user.controller;

import java.util.Optional;

import com.management.user.model.User;
import com.management.user.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    return userService.getId(id);
  }

  @GetMapping(value = "/name/{name}")
  public User getUserName(@PathVariable("name") String name) {
    return userService.getUserName(name);
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