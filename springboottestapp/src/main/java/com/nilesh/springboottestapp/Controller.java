package com.nilesh.springboottestapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/testapi/nilesh/")
public class Controller {

    @Autowired
    Repository repository;
    List<Model> employees = new ArrayList<>();
    @GetMapping ("/all")
    public List<Model> findAll()
    {
        return repository.findAll();
    }
}
