package com.nilesh.dozermapping;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
public class Config {

    @Bean
    public Mapper mapper()
    {
        return new DozerBeanMapper(Collections.singletonList("dozerBeanMapping.xml"));
    }
}
