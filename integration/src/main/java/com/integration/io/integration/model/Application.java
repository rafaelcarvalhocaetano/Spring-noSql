package com.integration.io.integration.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Application
 */
@Document
@AllArgsConstructor
@EqualsAndHashCode
public class Application {

    @Id
    @Getter
    private String id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String description;
    
    @Getter @Setter
    private String owner;
}