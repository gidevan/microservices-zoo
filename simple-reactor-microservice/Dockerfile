FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=build/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /simple-reactor-microservice/lib
COPY ${DEPENDENCY}/META-INF /simple-reactor-microservice/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /simple-reactor-microservice
ENTRYPOINT ["java","-cp","simple-reactor-microservice:simple-reactor-microservice/lib/*","org.vsanyc.microservices.zoo.simple.reactor.SimpleReactorApplication"]