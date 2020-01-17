package com.nilesh.rabbitpublisherusingsource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@EnableBinding({Source.class})
public class Scheduler {

    @Autowired
    Source source;
    @Autowired
    MessagePublisherController messagePublisherController;

    @Scheduled(fixedDelay = 1000)
    public void scheduleMessage() throws JsonProcessingException {
        Transaction transaction = new Transaction(1,"nilesh",27,"Chicago");
        Message message = MessageBuilder.withPayload(transaction).setHeader("myheader","headervalue").build();
        source.output().send(message);
        System.out.println("Message Sent---"+ transaction);

    }
}
