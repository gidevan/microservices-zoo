package org.vsanyc.microservices.zoo.simple.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.vsanyc.microservices.zoo.simple.domain.SimpleDto;
import org.vsanyc.microservices.zoo.simple.domain.SimpleEntity;
import org.vsanyc.microservices.zoo.simple.utils.SimpleEntityMapper;

@Service
public class SimpleServiceImpl implements SimpleService {

    @Value("${instance.value}")
    private String instanceValue;

    private static final String ENTITY_ID = "entityId";
    private static final String ENTITY_NAME = ENTITY_ID + " : instanceValue: ";

    @Override
    public SimpleDto getSimpleDto() {
        SimpleEntity simpleEntity = createSimpleEntity();
        return SimpleEntityMapper.INSTANCE.simpleEntityToDto(simpleEntity);
    }

    @Override
    public String getInstanceVersion() {
        return instanceValue;
    }

    private SimpleEntity createSimpleEntity() {
        SimpleEntity simpleEntity = new SimpleEntity();
        simpleEntity.setId(ENTITY_ID);
        simpleEntity.setEntityName(ENTITY_NAME + instanceValue);
        return simpleEntity;
    }
}
