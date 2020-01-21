## RabbitMQ publisher using Source class from Messaging 
1. Add web, cloud stream, Rabbit dependencies
2. Add amqp client
4. Annotate the MessagePublisherController with (EnableBinding(@Source.class))
   Autowire it and then use it to send the message to the exchange created as specified in the "application.properties" file.
   spring.cloud.stream.bindings.input.destination=commonexchange
