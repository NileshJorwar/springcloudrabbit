package com.nilesh.producer.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

@Service
public interface ProducerChannel {
      @Output
      MessageChannel consumer();

}
