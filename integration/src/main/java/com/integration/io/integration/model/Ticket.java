package com.integration.io.integration.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Ticket
 */
@Document
@EqualsAndHashCode
@AllArgsConstructor
public class Ticket {

    @Id
    private String id;

    @Getter @Setter
    private String title;

    @Getter @Setter
    private String description;

    @Getter @Setter
    private String appId;

    @Getter @Setter
    private String status;
    
}