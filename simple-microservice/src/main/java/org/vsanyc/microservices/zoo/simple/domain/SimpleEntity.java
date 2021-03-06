package org.vsanyc.microservices.zoo.simple.domain;

public class SimpleEntity {
    private String id;
    private String entityName;

    public SimpleEntity() {
    }

    public SimpleEntity(String id, String entityName) {
        this.id = id;
        this.entityName = entityName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }
}
