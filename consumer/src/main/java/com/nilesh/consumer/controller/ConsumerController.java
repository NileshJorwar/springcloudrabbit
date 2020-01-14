package com.nilesh.consumer.controller;

import com.nilesh.consumer.service.ConsumerChannels;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/consumer")
public class ConsumerController {

    /*@Bean
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
    }*/

    @GetMapping("/get")
    public String getMessage()
    {
        return "";
    }
}
