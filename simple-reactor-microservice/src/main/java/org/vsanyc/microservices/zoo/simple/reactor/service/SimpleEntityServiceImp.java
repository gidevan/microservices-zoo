package org.vsanyc.microservices.zoo.simple.reactor.service;

import org.springframework.stereotype.Service;
import org.vsanyc.microservices.zoo.simple.reactor.domain.Entity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SimpleEntityServiceImp implements SimpleEntityService {

    private static final String[] TEST_IDS = {"test1", "test2", "test3"};
    private static final String NAME_PREFIX = "Name_";

    private List<Entity> items = new ArrayList<>();

    @PostConstruct
    public void init() {
        items = Stream.of(TEST_IDS)
                .map(id -> new Entity(id, NAME_PREFIX + id))
                .collect(Collectors.toList());
    }

    @Override
    public Mono<Entity> findById(String id) {
        Optional<Entity> item = items.stream().filter(it -> it.getId().equals(id)).findFirst();
        return Mono.just(item.orElse(null));
    }

    @Override
    public Flux<Entity> findAll() {
        return Flux.fromIterable(items);
    }
}
