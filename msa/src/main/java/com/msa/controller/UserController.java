package com.msa.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.msa.dto.UserDTO;
import com.msa.model.User;
import com.msa.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/user")
public class UserController {

  @Autowired
  private UserService service;

  @GetMapping
  public ResponseEntity<Iterable<UserDTO>> list() {
    List<User> users = service.listAll();
    Iterable<UserDTO> listDto = users.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
    return ResponseEntity.ok().body(listDto);
  }


  @GetMapping(value = "/{id}")
  public ResponseEntity<UserDTO> getId(@PathVariable("id") String id) {
    User user = service.getId(id);
    return ResponseEntity.ok().body(new UserDTO(user));
  }

  @PostMapping
  public ResponseEntity<Void> createUser(@RequestBody UserDTO u) {
    User user = service.fromDTO(u);
    user = service.insert(user);

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }


}