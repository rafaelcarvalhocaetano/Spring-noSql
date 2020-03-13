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

  public User insert(User user) {
    return userRepository.insert(user);
  }
  
  public User fromDTO(UserDTO u) {
    return new User(u.getId(), u.getName(), u.getEmail());
  }

  public void delete(String id) {
    getId(id);
    userRepository.deleteById(id);
  }

  public User update(User user) {
    User newObj = getId(user.getId());
    updateData(newObj, user);
    return userRepository.save(newObj);
  }

  private void updateData(User newObj, User user) {
    newObj.setName(user.getName());
    newObj.setEmail(user.getEmail());
  }
}