package com.integration.io.integration.controller;

import com.integration.io.integration.model.Application;
import com.integration.io.integration.repository.ApplicationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * IController
 */
@RestController
@RequestMapping(value = "/application")
public class ApplicationController {

    @Autowired
    private ApplicationRepository applicationRepository;

    @GetMapping(value = "/{name}")
    public Iterable<Application> findByName(@PathVariable("name") String name) {
        return applicationRepository.findAll();
    }

    @DeleteMapping(value = "/{id}")
    public boolean deleteApp(@PathVariable("id") String id) {
        if (id != null) {
            applicationRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    
    
}