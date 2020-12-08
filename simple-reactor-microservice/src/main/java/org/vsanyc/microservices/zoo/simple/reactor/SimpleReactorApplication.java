package org.vsanyc.microservices.zoo.simple.reactor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.vsanyc.microservices.zoo.simple.reactor.web.SimpleReactorWebClient;

@SpringBootApplication
public class SimpleReactorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleReactorApplication.class, args);

        SimpleReactorWebClient srwc = new SimpleReactorWebClient();
        System.out.println(srwc.getResult());
    }

}
