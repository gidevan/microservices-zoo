package org.vsanyc.microservices.zoo.simple.service;

import org.vsanyc.microservices.zoo.simple.domain.SimpleDto;

public interface SimpleService {

    SimpleDto getSimpleDto();

    String getInstanceVersion();


}
