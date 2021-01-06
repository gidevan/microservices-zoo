package org.vsanyc.microservices.zoo.simple.reactor.service;

import org.vsanyc.microservices.zoo.simple.reactor.domain.Entity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface SimpleEntityService {

    Mono<Entity> findById(String id);
    Flux<Entity> findAll();
}
