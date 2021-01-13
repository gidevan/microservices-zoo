package org.vsanyc.microservices.zoo.simple.reactor.domain;

public class SimpleDto {
    private String id;
    private String dtoName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDtoName() {
        return dtoName;
    }

    public void setDtoName(String dtoName) {
        this.dtoName = dtoName;
    }
}
