package org.vsanyc.microservices.zoo.simple.utils;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.vsanyc.microservices.zoo.simple.domain.SimpleDto;
import org.vsanyc.microservices.zoo.simple.domain.SimpleEntity;

@Mapper
public interface SimpleEntityMapper {

    public static final SimpleEntityMapper INSTANCE = Mappers.getMapper( SimpleEntityMapper.class );

    @Mapping(source = "dtoName", target = "entityName")
    SimpleEntity simpleDtoToEntity(SimpleDto dto);

    @Mapping(source = "entityName", target = "dtoName")
    SimpleDto simpleEntityToDto(SimpleEntity entity);
}
