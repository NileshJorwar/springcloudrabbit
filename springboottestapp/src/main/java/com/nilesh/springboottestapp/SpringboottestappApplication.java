package com.nilesh.springboottestapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@EnableJpaRepositories(basePackageClasses = "com.nilesh.springboottestapp")
@SpringBootApplication
public class SpringboottestappApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringboottestappApplication.class, args);
    }
}
