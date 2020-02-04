package org.vsanyc.microservices.zoo.kafka.consumer.service;

import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    //private KafTemplate

    public String getConsumerInfo() {
        return "Kafka consumer service";
    }
}
