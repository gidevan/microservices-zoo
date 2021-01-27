package org.vsanyc.microservices.zoo.simple.sqs.cloud.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SqsCloudApp {

    private static Logger log = LoggerFactory.getLogger(SqsCloudApp.class);

    public static void main(String[] args) {
        log.info("Start SQS cloud example");
        SpringApplication.run(SqsCloudApp.class, args);
    }
}
