package com.integration.io.integration.service;

import com.integration.io.integration.model.Application;
import com.integration.io.integration.model.IApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 * ApplicationService
 */
@Service
public class ApplicationService implements IApplication {

    @Autowired
    private MongoTemplate mongo;

    @Override
    public void addApplicaition(Application app) {
        mongo.insert(app);
    }

    @Override
    public Application findByIdTempalte(String id) {
        return mongo.findById(id, Application.class);
    }

    @Override
    public void deleteTempalte(Application app) {
        mongo.remove(app);
    }

    @Override
    public void updateApplication(Application app) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(app.getClass().getName()));
        Update update = new Update();
        update.set("name", "Trainer");
        mongo.updateFirst(query, update, Application.class);
    }

    

  
    
}