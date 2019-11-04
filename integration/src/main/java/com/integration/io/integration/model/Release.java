package com.integration.io.integration.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Release
 */
@Document
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Release {

    @Id
    @Getter
    @Setter
    private String id;

    @Getter @Setter
    private String name;
    
    @Getter @Setter
    private String description;
    
    @Getter @Setter
    private List<Ticket> tickets;
    
    @Getter @Setter    
    private LocalDate releaseDate;

    
}