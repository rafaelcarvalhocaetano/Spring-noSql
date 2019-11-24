package com.address.controller;

import com.address.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Address
 */
@RestController
@RequestMapping(value = "/address")
public class Address {


  @Autowired
  private AddressService service;

  
}