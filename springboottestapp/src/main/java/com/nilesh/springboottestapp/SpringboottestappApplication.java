package com.nilesh.springboottestapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringboottestappApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringboottestappApplication.class, args);
    }
}
