## Creating Spring Cloud Application
1. Make sure you have added - 
    <spring-cloud.version>Hoxton.SR1</spring-cloud.version>
2. Make sure you added 
        <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-stream-rabbit</artifactId>
        </dependency>

3. Create the controller and run the program, it runs.
4. Create the Interface ProducerChannel and Define the MessageChannel with @Output annotation.
5. Enable the binding at the start of Springboot application using @EnableBinding(interface) where interface is where Output message channel is defined.
6. Autowire the interface in Controller to send the data.
7. No need to setup the RabbitMq properties(localhost, username and password) as they are added by default. (if to change default properties of localhost configuration, then add)
8. Once run the application, create the Exchange - consumerChannel similar to the MessageChannel defined in Service.
9. spring.cloud.stream.bindings.producer.destination= receiver property defined defines the "receiver" exchange in rabbit server.





