package org.vsanyc.microservices.zoo.kafka.producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vsanyc.microservices.zoo.kafka.producer.service.KafkaProducerService;

@RestController
public class KafkaProducerController {

    private KafkaProducerService kafkaProducerService;

    public KafkaProducerController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @GetMapping("/info")
    public String getInfo() {
        return kafkaProducerService.getServiceInfo();
    }

    @PostMapping("/send/{message}")
    public void sendMessage(@PathVariable String message) {
        kafkaProducerService.sendMessage(message);
    }
}
