package com.integration.io.integration.util;

import com.mongodb.MongoClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
/**
 * MongoConfiguration
 */
@Configuration
public class MongoConfiguration {

    // @Bean
    // public MongoClient mongoClient() {
    //     return new MongoClient("localhost");
    // }

    // @Bean
    // public MongoTemplate mongoTemplate() {
    //     return new MongoTemplate(mongoClient(), "ticket");
    // }

    // @Bean
    // public ReleaseCascadeConvertMongoEventListener release() {
    //     return new ReleaseCascadeConvertMongoEventListener();
    // }
    
}