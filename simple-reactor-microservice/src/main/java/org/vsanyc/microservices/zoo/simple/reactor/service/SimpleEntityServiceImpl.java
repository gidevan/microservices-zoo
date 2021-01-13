package org.vsanyc.microservices.zoo.simple.reactor.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.vsanyc.microservices.zoo.simple.reactor.domain.Entity;
import org.vsanyc.microservices.zoo.simple.reactor.domain.SimpleDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SimpleEntityServiceImpl implements SimpleEntityService {

    private static final String[] TEST_IDS = {"test1", "test2", "test3"};
    private static final String NAME_PREFIX = "Name_";

    private List<Entity> items = new ArrayList<>();

    @Value("${simple.microservice.url}")
    private String simpleMicroserviceUrl;

    @PostConstruct
    public void init() {
        items = Stream.of(TEST_IDS)
                .map(id -> new Entity(id, NAME_PREFIX + id))
                .collect(Collectors.toList());
    }

    @Override
    public Mono<Entity> findById(String id) {
        Optional<Entity> item = items.stream().filter(it -> it.getId().equals(id)).findFirst();
        return item.map(Mono :: just).orElse(Mono.empty());
    }

    @Override
    public Flux<Entity> findAll() {
        return Flux.fromIterable(items);
    }

    @Override
    public Mono<SimpleDto> findSimpleDto() {
        Mono<ClientResponse> response = WebClient.create(simpleMicroserviceUrl)
                .get().uri("/entity/dto")
                .accept(MediaType.APPLICATION_JSON)
                .exchange();
        return response.flatMap(res -> res.bodyToMono(SimpleDto.class));
    }
}
