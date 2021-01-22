package org.vsanyc.microservices.zoo.simple.sqs.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleSqsProducerApp {

    public static void main(String[] args) {
        SpringApplication.run(SimpleSqsProducerApp.class, args);
    }
}
