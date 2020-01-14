package com.nilesh.producer.controller;

import com.nilesh.producer.service.ProducerChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final MessageChannel consumer;

    public Controller(ProducerChannel channel)
    {
        this.consumer=channel.consumer();
    }

    @GetMapping("/greet/{name}")
    public String publish (@PathVariable String name)
    {
        String greeting = "Hello --" + name + "!";
        Message <String> message = MessageBuilder.withPayload(greeting).build();
        this.consumer.send(message);
        return greeting;
    }

}