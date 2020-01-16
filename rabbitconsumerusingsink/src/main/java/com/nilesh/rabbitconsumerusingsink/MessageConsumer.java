package com.nilesh.rabbitconsumerusingsink;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class MessageConsumer {

    @StreamListener(Sink.INPUT)
    public void consume(Transaction transaction)
    {
        System.out.println("Consumed Message---"+transaction.getName());
    }
}
