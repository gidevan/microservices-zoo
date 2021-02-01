package org.vsanyc.microservices.zoo.simple.sqs.cloud.example.domain;

public class PayloadEntity {

    private String message;
    private String description;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PayloadEntity{" +
                "message='" + message + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
