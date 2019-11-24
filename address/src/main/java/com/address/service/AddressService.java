package com.address.service;

import java.util.ArrayList;

import com.address.model.Address;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddressService  {


  public ResponseEntity<Iterable<Address>> listAll() {
    return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
  }

  
}