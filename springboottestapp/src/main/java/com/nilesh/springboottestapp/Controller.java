package com.nilesh.springboottestapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("testapi/nilesh/")
public class Controller {

    @GetMapping ("all")
    public void findAll(Integer age, Integer id, String name)
    {
//        return age + " "+ id + " "+ name;
        System.out.println("Hi" + age+ id + name);
    }

}
