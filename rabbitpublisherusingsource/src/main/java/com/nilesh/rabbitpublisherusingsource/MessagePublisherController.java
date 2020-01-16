package com.nilesh.rabbitpublisherusingsource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@EnableBinding({Source.class})
@RestController
public class MessagePublisherController {

    @Autowired
    Source source;

    @PostMapping(value = "/publish")
    public String sendMessage(@RequestBody String payload) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Transaction transaction = objectMapper.readValue(payload, Transaction.class);
        Message message = MessageBuilder.withPayload(transaction).setHeader("myheader","headervalue").build();
        source.output().send(message);
        System.out.println("Message Sent---"+ message);
        return "Sent Successfully...";
    }

}
