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
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Application {

    @Id
    private String id;
    private String name;
    private String description;
    private String owner;
}