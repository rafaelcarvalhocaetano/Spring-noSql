package com.integration.io.integration.controller;

import java.util.Optional;

import com.integration.io.integration.model.Release;
import com.integration.io.integration.repository.ReleaseRepository;

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
 * ReleaseController
 */
@RestController
@RequestMapping(value = "/release")
public class ReleaseController {

    @Autowired
    private ReleaseRepository releaseRepository;

    @GetMapping()
    public Iterable<Release> getAllReleases() {
        return releaseRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Release> getReleaseId(@PathVariable("id") String id) {
        return releaseRepository.findById(id);
    }

    @PostMapping()
    public Release addNewRelease(@RequestBody Release release){
        return releaseRepository.save(release);
    }

    @PutMapping(value = "/{id}")
    public Release updateRelease(@PathVariable("id") String id, @RequestBody Release release){
        release.setId(id);
        return releaseRepository.save(release);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteRelease(@PathVariable("id") String id) {
        releaseRepository.deleteById(id);
    }
    
}