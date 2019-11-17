package com.redis.controller;

import com.redis.model.Hotel;
import com.redis.repository.HotelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hotel")
public class HotelController {

  @Autowired
  private HotelRepository htl;

  @GetMapping()
  public Iterable<Hotel> getAll() {
      return htl.findAll();
  }  
}