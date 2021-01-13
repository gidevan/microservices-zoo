package org.vsanyc.microservices.zoo.simple.reactor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.vsanyc.microservices.zoo.simple.reactor.web.SimpleReactorWebClient;

@SpringBootApplication
public class SimpleReactorApplication {

    private static Logger log = LoggerFactory.getLogger(SimpleReactorApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SimpleReactorApplication.class, args);

        SimpleReactorWebClient srwc = new SimpleReactorWebClient();
        log.info("Call of remote service (simple-service)");
        log.info(srwc.getResult());
    }

}
