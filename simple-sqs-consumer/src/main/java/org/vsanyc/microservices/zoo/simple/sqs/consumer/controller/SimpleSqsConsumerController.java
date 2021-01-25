package org.vsanyc.microservices.zoo.simple.sqs.consumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vsanyc.microservices.zoo.simple.sqs.consumer.domain.SqsMessageBody;
import org.vsanyc.microservices.zoo.simple.sqs.consumer.service.SimpleSqsConsumerService;

import java.util.List;

@RestController
@RequestMapping("/sqs/consumer")
public class SimpleSqsConsumerController {

    private SimpleSqsConsumerService simpleSqsConsumerService;

    public SimpleSqsConsumerController(SimpleSqsConsumerService simpleSqsConsumerService) {
        this.simpleSqsConsumerService = simpleSqsConsumerService;
    }

    @GetMapping("/read")
    public List<SqsMessageBody> readMessages() {
        return simpleSqsConsumerService.readMessages();
    }

    @GetMapping("/read/delete")
    public List<SqsMessageBody> readAndDeleteMessages() {
        return simpleSqsConsumerService.readMessagesAndDelete();
    }
}
