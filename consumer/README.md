## Springboot application building
1. Importing integration module to handle the incoming of messages
2. Make sure to have the Rabbit and Spring cloud stream dependencies along with <dependencyManagement> cloud dependencies.
3. No Web dependency as it is receving the message. 
4. Annotate the main application class with @EnableBinding(ConsumerChannels.class) where channel is located
to continuous receiving of messages.
5. Create the Interface for Subscriber channel (for receiving of the messages).
6. Create the Service class (MessagingHandling) with Bean to listen to messages from Subscriber channel ("receiver" defined in application.properties).
The channel (exchange) defined in property file, creates the queue as well. This exchange defined should be the same as Publisher channel defined in property file of Producer. 
``
spring.cloud.stream.bindings.consumer.destination=receiver
spring.cloud.stream.bindings.producer.destination=receiver
``
7. Create the service class to receive the messages. Define the integrationflow by passing the Subscriber channel
created. 
``
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
``
8. spring.cloud.stream.bindings.consumer.destination=receiver creates exchange "receiver" and queue associated with it.
