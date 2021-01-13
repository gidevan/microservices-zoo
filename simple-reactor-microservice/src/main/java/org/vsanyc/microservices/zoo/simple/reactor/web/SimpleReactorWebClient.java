package org.vsanyc.microservices.zoo.simple.reactor.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

@Component
public class SimpleReactorWebClient {

    private Logger log = LoggerFactory.getLogger(SimpleReactorWebClient.class);
    private static final String DEFAULT_PORT = "8081";
    private static final String DEFAULT_URL = "http://localhost:" + DEFAULT_PORT;

    @Value("${server.port:8081}")
    private String port;

    private WebClient client;

    @PostConstruct
    public void init() {
        log.info("Init in postConstruct method");
        client = WebClient.create("http://localhost:" + port);
    }

    public String getResult() {
        log.info("Get result method. Configured port: {}", port);
        if (client == null) {
            log.info("Default webClient initialization");
            client = WebClient.create(DEFAULT_URL);
        }
        Mono<ClientResponse> result = client.get()
                .uri("/hello")
                .accept(MediaType.TEXT_PLAIN)
                .exchange();
        return ">> result = " + result.flatMap(res -> res.bodyToMono(String.class)).block();
    }
}
