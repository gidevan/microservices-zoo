package org.vsanyc.microservices.zoo.simple.sqs.consumer.service;

import org.vsanyc.microservices.zoo.simple.sqs.consumer.domain.SqsMessageBody;
import software.amazon.awssdk.services.sqs.model.Message;

import java.util.List;

public interface SimpleSqsConsumerService {

    List<SqsMessageBody> readMessages();

    List<SqsMessageBody> readMessagesAndDelete();
}
