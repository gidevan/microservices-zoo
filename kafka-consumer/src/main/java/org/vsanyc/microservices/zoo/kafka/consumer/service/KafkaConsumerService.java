package org.vsanyc.microservices.zoo.kafka.consumer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaConsumerService {

    private List<String> messages = new ArrayList<>();

    @Value("${kafka.consumer.id}")
    private String kafkaConsumerId;
    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;

    public String getConsumerInfo() {
        return "Kafka consumer service" + kafkaConsumerId;
    }

    @KafkaListener(topics = "test")
    public void listen(String message) {
        System.out.println("Received Message in group [ "+ groupId + "]: " + message);
        messages.add(message);
    }


    public List<String> getReceivedMessages() {
        return messages;
    }

}
