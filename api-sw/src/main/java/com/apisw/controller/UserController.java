package com.apisw.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.apisw.DTO.UserDTO;
import com.apisw.model.Post;
import com.apisw.model.User;
import com.apisw.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping(value = "/user")
public class UserController {

  @Autowired
  private UserService service;

  @GetMapping()
  public ResponseEntity<List<UserDTO>> findAll() {
    List<User> listUser = service.findAll();
    List<UserDTO> listUserDTO = listUser.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
    return ResponseEntity.ok().body(listUserDTO);
  }


  @GetMapping(value = "/{id}")
  public ResponseEntity<UserDTO> findById(@PathVariable("id") String id) {
    return ResponseEntity.ok().body(new UserDTO(service.findById(id)));
  }

  @PostMapping()
  public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO) {
    User obj = service.frontDTO(userDTO);
    obj = service.insert(obj);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") String id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping()
  public ResponseEntity<Void> update(@RequestBody User udto) {
    service.update(udto);
    return ResponseEntity.noContent().build();
  }

  @GetMapping(value = "{id}/post")
  public ResponseEntity<Iterable<Post>> findPost(@PathVariable String id) {
    User user = service.findById(id);
    return ResponseEntity.ok().body(user.getPosts());
  }
  
}