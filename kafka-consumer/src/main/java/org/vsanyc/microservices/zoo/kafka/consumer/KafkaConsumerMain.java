package org.vsanyc.microservices.zoo.kafka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaConsumerMain {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(KafkaConsumerMain.class);
        app.run(args);
    }
}
