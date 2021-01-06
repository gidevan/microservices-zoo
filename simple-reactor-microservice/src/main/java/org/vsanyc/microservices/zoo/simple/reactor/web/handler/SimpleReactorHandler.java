package org.vsanyc.microservices.zoo.simple.reactor.web.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.vsanyc.microservices.zoo.simple.reactor.domain.Entity;
import org.vsanyc.microservices.zoo.simple.reactor.service.SimpleEntityService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class SimpleReactorHandler {
    @Autowired
    private SimpleEntityService simpleEntityService;

    public Mono<ServerResponse> hello(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("Hello, Spring! Simple reactor microservice"));
    }

    public Mono<ServerResponse> system(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("System call"));
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        String id = request.pathVariable("id");
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(simpleEntityService.findById(id), Entity.class);
    }

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(simpleEntityService.findAll(), Entity.class);
    }
}
