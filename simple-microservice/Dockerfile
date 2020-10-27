FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=build/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /simple-microservice/lib
COPY ${DEPENDENCY}/META-INF /simple-microservice/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /simple-microservice
ENTRYPOINT ["java","-cp","simple-microservice:simple-microservice/lib/*","org.vsanyc.microservices.zoo.simple.SimpleMicroserviceApp"]