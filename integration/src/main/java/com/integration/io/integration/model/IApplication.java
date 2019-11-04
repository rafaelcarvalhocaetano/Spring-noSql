package com.integration.io.integration.model;

/**
 * IApplication
 */
public interface IApplication {

    void addApplicaition(Application app);

    Application findByIdTempalte(String id);

    void deleteTempalte(Application app);

    void updateApplication(Application app);
}