package com.management.user.controller;

import java.util.List;
import java.util.Optional;

import com.management.user.exceptions.UserNotFoundException;
import com.management.user.model.Order;
import com.management.user.model.User;
import com.management.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
@Validated
public class OrderController {

  @Autowired
  private UserRepository userRepository;


  @GetMapping(value = "/{userId}/orders")
  public List<Order> getAllOrders(@PathVariable Long userId) throws UserNotFoundException {

    Optional<User> user = userRepository.findById(userId);
    if (!user.isPresent()) {
      throw new UserNotFoundException("Não encontrado");
    }
    return user.get().getOrder();
  }
  
}