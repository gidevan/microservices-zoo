package org.vsanyc.microservices.zoo.kafka.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaConsumerService {

    private List<String> messages = new ArrayList<>();

    public String getConsumerInfo() {
        return "Kafka consumer service";
    }

    @KafkaListener(topics = "test")
    public void listen(String message) {
        System.out.println("Received Messasge in group foo: " + message);
        messages.add(message);
    }


    public List<String> getReceivedMessages() {
        return messages;
    }

}
