package org.vsanyc.microservices.zoo.simple.sqs.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.CreateQueueRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageResponse;
import software.amazon.awssdk.services.sqs.model.SqsException;

import javax.annotation.PostConstruct;


@Service
public class SimpleSqsServiceImpl implements SimpleSqsService {

    private Logger logger = LoggerFactory.getLogger(SimpleSqsServiceImpl.class);

    private static final String QUEUE_URL = "https://sqs.us-east-2.amazonaws.com/403704356203/SimpleQueue";

    private SqsClient sqsClient;

    @PostConstruct
    public void postConstruct() {
        sqsClient = SqsClient.builder()
                .region(Region.US_EAST_2)
                .build();
    }

    @Override
    public SendMessageResponse sendMessage(String message) {

       SendMessageRequest sendMessageRequest = SendMessageRequest.builder()
                .queueUrl(QUEUE_URL)
                .messageBody(message)
                .delaySeconds(5)
                .build();
       logger.info("Send message [{}]", message);
       SendMessageResponse response = sqsClient.sendMessage(sendMessageRequest);
       logger.info("Message is sent");
       logger.info(response.toString());
       return response;
    }
}
