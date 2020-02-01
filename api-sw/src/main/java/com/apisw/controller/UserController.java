package com.apisw.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.apisw.DTO.UserDTO;
import com.apisw.model.User;
import com.apisw.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
  
}