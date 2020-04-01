package com.nilesh.springboottestapp;

import org.springframework.stereotype.Service;

@Service
public class StatusServiceFields {
    private int age=10;
    private int id=100000;
    private String name="Nilesh";

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = 10;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

}
