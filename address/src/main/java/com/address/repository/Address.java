package com.address.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Address extends JpaRepository<Address, Integer>{

  
}