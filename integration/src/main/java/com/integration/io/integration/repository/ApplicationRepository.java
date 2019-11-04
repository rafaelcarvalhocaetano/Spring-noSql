package com.integration.io.integration.repository;

import java.util.List;

import com.integration.io.integration.model.Application;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * ReleaseRepository
 */
@Repository
public interface ApplicationRepository extends MongoRepository<Application, String>{

    List<Application> findByName(String name);


    
}