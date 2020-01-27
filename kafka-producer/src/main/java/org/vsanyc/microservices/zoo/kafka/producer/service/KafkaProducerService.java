package org.vsanyc.microservices.zoo.kafka.producer.service;

import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    public String getServiceInfo() {
        return "Kafka Producer Service";
    }
}
