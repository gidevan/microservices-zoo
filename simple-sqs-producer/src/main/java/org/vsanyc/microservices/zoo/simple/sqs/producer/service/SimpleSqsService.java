package org.vsanyc.microservices.zoo.simple.sqs.producer.service;

import software.amazon.awssdk.services.sqs.model.SendMessageResponse;
import software.amazon.awssdk.services.sqs.model.SqsException;

public interface SimpleSqsService {

    SendMessageResponse sendMessage(String message) throws SqsException;
}
