package org.vsanyc.microservices.zoo.simple.reactor.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vsanyc.microservices.zoo.simple.reactor.domain.Entity;
import org.vsanyc.microservices.zoo.simple.reactor.service.SimpleEntityService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reactorctrl")
public class SimpleController {
    @Autowired
    private SimpleEntityService simpleEntityService;

    @GetMapping("/entity/{id}")
    public Mono<Entity> findById(String id) {
        return simpleEntityService.findById(id);
    }

    @GetMapping("/entity")
    public Flux<Entity> findAll() {
        return simpleEntityService.findAll();
    }
}
