package com.nilesh.producer2.controller;

import com.nilesh.producer2.service.ProducerChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/producer")
public class ProducerController {

        //One way instead of autowiring ProducerChannel
        /*
            MessageChannel messageChannel;
            public ProducerController(ProducerChannel producerChannel)
            {
                this.messageChannel=producerChannel.producer();
            }
        */

    @Autowired
    ProducerChannel channel;

    @GetMapping("/all")
    public String findAll()
    {
        return "Sample Producer";
    }

    @GetMapping("/publish/{text}")
    public String publishMessage(@PathVariable String text)
    {
        Message<String> message = MessageBuilder
                .withPayload(text)
                .build();

        //messageChannel.send(message);

        //Sending messages to Consumer channel (receiving messages)
        channel.consumerChannel().send(message);
        return "Message Sent Successfully -- "+ message;
    }
}
