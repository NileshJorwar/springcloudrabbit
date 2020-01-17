package com.nilesh.rabbitpublisherusingsource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RabbitpublisherusingsourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitpublisherusingsourceApplication.class, args);
    }

}
