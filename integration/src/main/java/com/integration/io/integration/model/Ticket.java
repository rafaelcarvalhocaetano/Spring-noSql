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
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class Ticket {

    @Id
    private String id;
    private String title;
    private String description;
    private String appId;
    private String status;
    
}