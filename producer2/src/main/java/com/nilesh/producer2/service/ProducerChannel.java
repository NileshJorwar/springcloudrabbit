package com.nilesh.producer2.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

@Service
public interface ProducerChannel {

    // Sending the messages to this Output Channel
    @Output("producer")
    MessageChannel consumerChannel();

}