package org.vsanyc.microservices.zoo.simple.sqs.cloud.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Service;
import org.vsanyc.microservices.zoo.simple.sqs.cloud.example.domain.PayloadEntity;

@Service
public class SqsCloudServiceImpl implements SqsCloudService {

    private Logger logger = LoggerFactory.getLogger(SqsCloudServiceImpl.class);

    @Value("${cloud.aws.queue}")
    private String queue;

    private QueueMessagingTemplate template;

    public SqsCloudServiceImpl(QueueMessagingTemplate template) {
        this.template = template;
    }

    @Override
    public void sendEntity(PayloadEntity entity) {
        logger.info("Send to: [{}], payload: [{}]....", queue, entity.toString());
        template.convertAndSend(queue, entity);
    }
}
