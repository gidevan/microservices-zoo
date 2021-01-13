package org.vsanyc.microservices.zoo.simple.reactor.service;

import org.vsanyc.microservices.zoo.simple.reactor.domain.Entity;
import org.vsanyc.microservices.zoo.simple.reactor.domain.SimpleDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SimpleEntityService {

    Mono<Entity> findById(String id);
    Flux<Entity> findAll();
    Mono<SimpleDto> findSimpleDto();
}
