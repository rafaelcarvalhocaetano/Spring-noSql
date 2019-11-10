package com.library.io.library.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 */
@RestController
@RequestMapping(value = "kafka")
public class UserController {
   
    @GetMapping()
    public String getInfo() {
        return "KAFKA MAIN";
    }
}