package org.vsanyc.microservices.zoo.simple.service;

import org.vsanyc.microservices.zoo.simple.domain.SimpleDto;
import org.vsanyc.microservices.zoo.simple.domain.SimpleEntity;

import java.util.List;

public interface SimpleService {

    SimpleDto getSimpleDto();

    String getInstanceVersion();

    List<SimpleEntity> getSimpleEntities();

    SimpleEntity getSimpleEntityById(String id);
}
