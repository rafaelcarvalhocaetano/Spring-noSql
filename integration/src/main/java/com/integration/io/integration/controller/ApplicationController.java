package com.integration.io.integration.controller;

import java.util.Optional;

import com.integration.io.integration.model.Application;
import com.integration.io.integration.repository.ApplicationRepository;
import com.integration.io.integration.service.ApplicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    private ApplicationService appService;

    @GetMapping()
    public Iterable<Application> getAllApp() {
        return applicationRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Application> getByName(@PathVariable("id") String id) {
        return applicationRepository.findById(id);
    }

    @PostMapping()
    public Application newApp(@RequestBody Application app) {
        return applicationRepository.save(app);
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

    @PutMapping(value = "/{temp}")
    public void update(@RequestBody Application app) {
        appService.updateApplication(app);
    }

    
    
}