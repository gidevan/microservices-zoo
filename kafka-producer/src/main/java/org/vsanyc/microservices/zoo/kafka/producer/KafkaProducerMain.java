package org.vsanyc.microservices.zoo.kafka.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProducerMain {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(KafkaProducerMain.class);
        app.run(args);
    }
}
