package org.vsanyc.microservices.zoo.kafka.consumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vsanyc.microservices.zoo.kafka.consumer.service.KafkaConsumerService;

@RestController
public class KafkaConsumerController {

    private KafkaConsumerService kafkaConsumerService;

    public KafkaConsumerController(KafkaConsumerService kafkaConsumerService) {
        this.kafkaConsumerService = kafkaConsumerService;
    }

    @GetMapping("/info")
    public String getConsumerInfo() {
        return kafkaConsumerService.getConsumerInfo();
    }
}
