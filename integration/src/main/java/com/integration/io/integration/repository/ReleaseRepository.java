package com.integration.io.integration.repository;

import com.integration.io.integration.model.Release;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * ReleaseRepository
 */
@Repository
public interface ReleaseRepository extends MongoRepository<Release, String>{

    
}