package org.vsanyc.microservices.zoo.simple.sqs.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.vsanyc.microservices.zoo.simple.sqs.consumer.domain.SqsMessageBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.DeleteMessageRequest;
import software.amazon.awssdk.services.sqs.model.DeleteMessageResponse;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SimpleSqsConsumerServiceImpl implements SimpleSqsConsumerService {

    private Logger logger = LoggerFactory.getLogger(SimpleSqsConsumerServiceImpl.class);

    private static final String QUEUE_URL = "https://sqs.us-east-2.amazonaws.com/403704356203/SimpleQueue";

    private SqsClient sqsClient;

    @PostConstruct
    public void postConstruct() {
        sqsClient = SqsClient.builder()
                .region(Region.US_EAST_2)
                .build();
    }

    @Override
    public List<SqsMessageBody> readMessages() {
        ReceiveMessageRequest rq = ReceiveMessageRequest.builder()
                .queueUrl(QUEUE_URL)
                .build();
        List<Message> msgs = sqsClient.receiveMessage(rq).messages();

        return msgs.stream().map(msg -> {
            logger.info("Message([{}], [{}])", msg.messageId(), msg.body());
            return new SqsMessageBody(msg.messageId(), msg.body());
        }).collect(Collectors.toList());
    }

    @Override
    public List<SqsMessageBody> readMessagesAndDelete() {
        ReceiveMessageRequest rq = ReceiveMessageRequest.builder()
                .queueUrl(QUEUE_URL)
                .build();
        List<Message> msgs = sqsClient.receiveMessage(rq).messages();

        return msgs.stream().map(msg -> {
            logger.info("Message([{}], [{}])", msg.messageId(), msg.body());
            DeleteMessageResponse deleteMessageResponse = deleteMessage(msg);
            logger.info("Message [{}] is deleted. DeleteResponse: {}", msg.messageId(), deleteMessageResponse.toString());
            return new SqsMessageBody(msg.messageId(), msg.body());
        }).collect(Collectors.toList());
    }

    private DeleteMessageResponse deleteMessage(Message message) {
        DeleteMessageRequest deleteRequest = DeleteMessageRequest.builder()
                .queueUrl(QUEUE_URL)
                .receiptHandle(message.receiptHandle())
                .build();
        return sqsClient.deleteMessage(deleteRequest);
    }
}
