package org.vsanyc.microservices.zoo.simple.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SimpleController {

    private static final String INSTANCE_VALUE_MSG = "Instance value: ";

    private Logger logger = LoggerFactory.getLogger(SimpleController.class);

    @Value("${instance.value}")
    private String instanceValue;

    @GetMapping("/instance/value")
    public String getInstanceValue() {
        logger.info("Get instance value: {}", instanceValue);
        return INSTANCE_VALUE_MSG + instanceValue;
    }
}
