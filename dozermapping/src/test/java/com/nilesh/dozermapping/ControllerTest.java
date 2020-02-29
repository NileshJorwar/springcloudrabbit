package com.nilesh.dozermapping;

import com.nilesh.dozermapping.service.MapperService;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
//@SpringBootTest(classes = Controller.class)
@Import(ControllerTest.ConfigurationMapper.class)
class ControllerTest {

    private Controller controller;
    private MapperService mockMapperService;

    @Autowired
    private Mapper mapper;

    @BeforeEach
    public void setUp()
    {
        mockMapperService=mock(MapperService.class);
        //mapper = new DozerBeanMapper(Collections.singletonList("dozerBeanMapping.xml"));
        controller = new Controller(mapper,mockMapperService);
    }

    @Test
    public void getDozerData_should_return_string()
    {
        when(mockMapperService.getDozerData()).thenReturn("Name-nilesh");
        String actualResult= controller.getDozerData();
        verify(mockMapperService, times(1)).getDozerData();
        assertThat(actualResult).isNotNull();
    }

    @TestConfiguration
    static class ConfigurationMapper
    {
        @Bean
        public Mapper mapper()
        {
            return new DozerBeanMapper(Collections.singletonList("dozerBeanMapping.xml"));
        }
    }
}