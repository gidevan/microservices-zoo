package org.vsanyc.microservices.zoo.simple.sqs.cloud.example.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import org.vsanyc.microservices.zoo.simple.sqs.cloud.example.domain.PayloadEntity;
import org.vsanyc.microservices.zoo.simple.sqs.cloud.example.service.SqsCloudServiceImpl;

import javax.validation.Valid;

@Component
public class SqsCloudListener {

    private Logger logger = LoggerFactory.getLogger(SqsCloudListener.class);

    @Value("${cloud.aws.queue}")
    private String queue;

    @SqsListener(value = "SimpleQueue1", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void getMessageFromSqs(@Valid PayloadEntity payloadEntity, @Header("MessageId") String messageId) {
        logger.info("Received message= [{}] with messageId= {}", payloadEntity.toString(), messageId);
    }
}
