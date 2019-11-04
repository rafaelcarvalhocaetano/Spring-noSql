package com.integration.io.integration.controller;

import java.util.Optional;
import java.util.stream.Stream;

import com.integration.io.integration.model.Ticket;
import com.integration.io.integration.repository.TicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * TicketController
 */
@RestController
@RequestMapping(value = "/ticket")
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping()
    public Iterable<Ticket> getTicketAll() {
        return ticketRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Ticket> getById(@PathVariable("id") String id) {
        return ticketRepository.findById(id);
    }

    @PostMapping()
    public Ticket addNewTicket(@RequestBody Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @PutMapping(value = "/{id}")
    public Ticket updateTicket(@PathVariable("id") String id, Ticket ticket) {
        // ticket.setId(id);
        return ticketRepository.save(ticket);
    }

    @DeleteMapping(value = "/{id}")
    public boolean deleteTicket(@PathVariable("id") String id) {
        if (id != null) {
            ticketRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @GetMapping(value = "/status/{status}")
    public Iterable<Ticket> findByStatus(@PathVariable("status") String status) {
        return ticketRepository.findByStatus(status);
    }

    @GetMapping(value="/count")
    public Long getCountAllTIcket() {
        Stream<Ticket> stream = ticketRepository.findAllByCustomQueryAndStream("Open");
        Long count = stream.count();
        stream.close();
        return count;
    }
    
}