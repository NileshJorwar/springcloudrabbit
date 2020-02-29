package com.nilesh.dozermapping;

import com.nilesh.dozermapping.service.MapperService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nilesh/dozermapping")
public class Controller {

    // Needs to have Mapper Autowired for third method and bean defined in main class file
    @Autowired
    private Mapper mapper;
    @Autowired
    private MapperService mapperService;

    public Controller(Mapper mapper, MapperService mapperService)
    {
        this.mapper=mapper;
        this.mapperService=mapperService;
    }
    // Not needed autowired mapper for below method
    @GetMapping("/dozerdatausingbeanmapper")
    public String getDozerData()
    {
        return mapperService.getDozerData();
    }

    @GetMapping("/dozerdatausingsingletonwrapper")
    public String getDozerDataUsingsingletonwrapper()
    {
        return mapperService.getDozerDataUsingSinggletonMapper();
    }

    @GetMapping("/dozerdatausingautowiredmapper")
    public String getDozerDataUsingAutowiredMapper()
    {
        return mapperService.getDozerDataUsingAutowiredMapper(mapper);
    }
}

