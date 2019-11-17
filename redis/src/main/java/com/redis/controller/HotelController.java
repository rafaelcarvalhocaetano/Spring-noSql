package com.redis.controller;

import java.util.List;

import com.redis.model.Hotel;
import com.redis.repository.HotelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hotel")
public class HotelController {

  @Autowired
  private HotelRepository hotelRepository;

  @GetMapping()
  public Iterable<Hotel> getAll() {
    return hotelRepository.findAll();
  }
  
}