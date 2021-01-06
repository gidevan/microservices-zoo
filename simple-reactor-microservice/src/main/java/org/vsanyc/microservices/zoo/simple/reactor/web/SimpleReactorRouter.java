package org.vsanyc.microservices.zoo.simple.reactor.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.vsanyc.microservices.zoo.simple.reactor.web.handler.SimpleReactorHandler;

@Configuration
public class SimpleReactorRouter {

    @Bean
    public RouterFunction<ServerResponse> route(SimpleReactorHandler greetingHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/hello")
                        .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), greetingHandler::hello)
                .andRoute(RequestPredicates.GET("/system")
                        .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), greetingHandler::system)
                .andRoute(RequestPredicates.GET("/entity/{id}")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), greetingHandler::findById)
                .andRoute(RequestPredicates.GET("/entity")
                    .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), greetingHandler::findAll);
    }
}
