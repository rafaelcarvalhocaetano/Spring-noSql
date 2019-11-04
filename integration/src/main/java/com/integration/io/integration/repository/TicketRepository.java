package com.integration.io.integration.repository;

import java.util.List;
import java.util.stream.Stream;

import com.integration.io.integration.model.Ticket;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * ReleaseRepository
 */
@Repository
public interface TicketRepository extends MongoRepository<Ticket, String>{

    List<Ticket> findByStatus(String status);

    @Query("{ 'satus' : ?0 }")
    Stream<Ticket> findAllByCustomQueryAndStream(String status);

    
}