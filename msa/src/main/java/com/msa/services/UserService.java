package com.msa.services;

import java.util.List;
import java.util.Optional;

import com.msa.dto.UserDTO;
import com.msa.exceptions.UserExceptions;
import com.msa.model.User;
import com.msa.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public List<User> listAll() {
    return userRepository.findAll();
  }

  public User getId(String id) {
   Optional<User> obj = userRepository.findById(id);
   return obj.orElseThrow(() -> new UserExceptions("Usuário não encontrado"));
  }
  
}