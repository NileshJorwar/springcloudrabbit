package com.nilesh.dozermapping.service;

import com.nilesh.dozermapping.EmployeeDTO;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class MapperServiceTest {

    private MapperService mapperService;
@BeforeEach
   public void setup() {
        mapperService = new MapperService();
    }
    @Test

    public void getDozerData_should_throw_exception()
    {
        assertThat(mapperService.getDozerData()).isEqualTo("Name--Nilesh");
    }
}