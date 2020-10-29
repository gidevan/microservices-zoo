package org.vsanyc.microservices.zoo.simple.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vsanyc.microservices.zoo.simple.domain.SimpleDto;
import org.vsanyc.microservices.zoo.simple.service.SimpleService;


@RestController
public class SimpleController {

    private static final String INSTANCE_VALUE_MSG = "Instance value: ";

    private Logger logger = LoggerFactory.getLogger(SimpleController.class);

    @Autowired
    private SimpleService simpleService;

    @GetMapping("/instance/value")
    public String getInstanceValue() {
        String instanceValue = simpleService.getInstanceVersion();
        logger.info("Get instance value: {}", instanceValue);
        return INSTANCE_VALUE_MSG + instanceValue;
    }

    @GetMapping("/entity")
    public SimpleDto getSimpleDto() {
        return simpleService.getSimpleDto();
    }
}
