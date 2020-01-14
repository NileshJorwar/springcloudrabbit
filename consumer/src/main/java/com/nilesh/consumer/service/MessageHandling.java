package com.nilesh.consumer.service;

import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class MessageHandling {

    @Bean
    @Scope("prototype")
    Logger logger(InjectionPoint injectionPoint)
    {
        return Logger.getLogger(injectionPoint.getDeclaredType().getName());
    }

    @Bean
    IntegrationFlow integrationFlow(ConsumerChannels consumerChannels){
        return IntegrationFlows.from(consumerChannels.producerChannel())
                .handle(String.class, (payload, headers)->{
                    //logger().info("Message ---"+payload);
                    System.out.println("Message--"+ payload);
                    return null;
                })
                .get();
    }
}
