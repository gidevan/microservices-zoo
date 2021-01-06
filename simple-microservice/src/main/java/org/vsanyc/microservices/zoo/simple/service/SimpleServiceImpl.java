package org.vsanyc.microservices.zoo.simple.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.vsanyc.microservices.zoo.simple.domain.SimpleDto;
import org.vsanyc.microservices.zoo.simple.domain.SimpleEntity;
import org.vsanyc.microservices.zoo.simple.utils.SimpleEntityMapper;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SimpleServiceImpl implements SimpleService {

    private static final String ENTITY_ID = "entityId";
    private static final String ENTITY_NAME = ENTITY_ID + " : instanceValue: ";
    private static final String[] IDS = {"testId22", "testId13", "testId94", "testId55"};
    private static final String ENTITY_NAME_PREFIX = "TestEntityName_";

    private List<SimpleEntity> entities;

    @Value("${instance.value}")
    private String instanceValue;

    @PostConstruct
    public void init() {
        entities = Stream.of(IDS).map(id -> new SimpleEntity(id, ENTITY_NAME_PREFIX + id))
                .collect(Collectors.toList());
    }

    @Override
    public SimpleDto getSimpleDto() {
        SimpleEntity simpleEntity = new SimpleEntity(ENTITY_ID, ENTITY_NAME);
        return SimpleEntityMapper.INSTANCE.simpleEntityToDto(simpleEntity);
    }

    @Override
    public String getInstanceVersion() {
        return instanceValue;
    }

    @Override
    public List<SimpleEntity> getSimpleEntities() {
        return entities;
    }

    @Override
    public SimpleEntity getSimpleEntityById(String id) {
        return entities.stream().filter(entity -> entity.getId().equals(id)).findFirst()
                .orElse(null);
    }
}
