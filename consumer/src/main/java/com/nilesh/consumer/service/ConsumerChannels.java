package com.nilesh.consumer.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Service;

@Service
public interface ConsumerChannels {

    @Input("consumer")
    SubscribableChannel producerChannel();
}
