package org.vsanyc.microservices.zoo.simple.sqs.cloud.example.service;

import org.vsanyc.microservices.zoo.simple.sqs.cloud.example.domain.PayloadEntity;

public interface SqsCloudService {
    void sendEntity(PayloadEntity entity);
}
