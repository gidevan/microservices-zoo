package org.vsanyc.microservices.zoo.kafka.producer.service;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafkaProducerService {

    @Value("${test.kafka.topic.name}")
    private String topicName;

    private KafkaTemplate kafkaTemplate;

    public KafkaProducerService(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public String getServiceInfo() {
        return "Kafka Producer Service";
    }

    public void sendMessage(String message) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("Sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=["
                        + message + "] due to : " + ex.getMessage());
            }
        });
    }

    public void sendProducerRecordData(String key, String value) {
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topicName, key, value);
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(producerRecord);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send record =[] due to : " + ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                ProducerRecord<String, String> record = result.getProducerRecord();
                System.out.println("Sent producer record=[" + record.key() + ":" + record.value()
                        + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
        });
    }
}
