package org.vsanyc.microservices.zoo.simple.sqs.cloud.example.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vsanyc.microservices.zoo.simple.sqs.cloud.example.domain.PayloadEntity;
import org.vsanyc.microservices.zoo.simple.sqs.cloud.example.service.SqsCloudService;

@RestController
@RequestMapping("cloud/sqs")
public class SqsCloudController {

    private SqsCloudService sqsCloudService;

    public SqsCloudController(SqsCloudService sqsCloudService) {
        this.sqsCloudService = sqsCloudService;
    }

    @RequestMapping("/send")
    public void sendMessage(@RequestBody PayloadEntity payloadEntity) {
        sqsCloudService.sendEntity(payloadEntity);
    }
}
