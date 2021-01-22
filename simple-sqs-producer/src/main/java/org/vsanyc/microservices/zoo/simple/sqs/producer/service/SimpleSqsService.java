package org.vsanyc.microservices.zoo.simple.sqs.producer.service;

public interface SimpleSqsService {

    void sendMessage(String message);
}
