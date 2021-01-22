package org.vsanyc.microservices.zoo.simple.sqs.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.vsanyc.microservices.zoo.simple.sqs.producer.service.SimpleSqsService;

@RestController
@RequestMapping("/sqs")
public class SqsProducerController {

    @Autowired
    private SimpleSqsService simpleSqsService;

    @GetMapping("/name")
    public String getName() {
        return "SimpleSqsProducer";
    }

    @GetMapping("/send/{message}")
    public String sendMessage(@PathVariable String message) {
        simpleSqsService.sendMessage(message);
        return "sent";
    }
}
