package org.vsanyc.microservices.zoo.simple.sqs.producer.service;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.CreateQueueRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;
import software.amazon.awssdk.services.sqs.model.SqsException;

import javax.annotation.PostConstruct;

@Service
public class SimpleSqsServiceImpl implements SimpleSqsService {

    private static final String  QUEUE_NAME= "SimpleQueue";
    private static final String QUEUE_URL = "https://sqs.us-east-2.amazonaws.com/403704356203/SimpleQueue";

    private SqsClient sqsClient;

    @PostConstruct
    public void postConstruct() {
        sqsClient = SqsClient.builder()
                .region(Region.US_EAST_2)
                .build();
    }

    @Override
    public void sendMessage(String message) {
        try {
            CreateQueueRequest request = CreateQueueRequest.builder()
                    .queueName(QUEUE_NAME)
                    .build();

            SendMessageRequest sendMessageRequest = SendMessageRequest.builder()
                    .queueUrl(QUEUE_URL)
                    .messageBody(message)
                    .delaySeconds(5)
                    .build();

            sqsClient.sendMessage(sendMessageRequest);

        } catch (SqsException e) {

        }
    }
}
