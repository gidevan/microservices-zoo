package org.vsanyc.microservices.zoo.simple.sqs.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleSqsConsumerApp {

    public static void main(String[] args) {
        SpringApplication.run(SimpleSqsConsumerApp.class, args);
    }
}
