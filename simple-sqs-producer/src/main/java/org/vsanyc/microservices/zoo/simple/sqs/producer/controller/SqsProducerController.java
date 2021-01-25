package org.vsanyc.microservices.zoo.simple.sqs.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.vsanyc.microservices.zoo.simple.sqs.producer.domain.SqsMessage;
import org.vsanyc.microservices.zoo.simple.sqs.producer.service.SimpleSqsService;
import software.amazon.awssdk.services.sqs.model.SendMessageResponse;

@RestController
@RequestMapping("/sqs")
public class SqsProducerController {

    private SimpleSqsService simpleSqsService;

    public SqsProducerController(SimpleSqsService simpleSqsService) {
        this.simpleSqsService = simpleSqsService;
    }

    @GetMapping("/name")
    public String getName() {
        return "SimpleSqsProducer";
    }

    @PostMapping("/send")
    public String sendMessage(@RequestBody SqsMessage message) {
        return simpleSqsService.sendMessage(message.getMessage())
                .toString();
    }
}
