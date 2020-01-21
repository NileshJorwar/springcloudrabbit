## RabbitMQ publisher using Source class from Messaging 
1. Add web, cloud stream, Rabbit dependencies
2. Add amqp client
3. Adding Jackson dependency for JSON data publish.
4. Annotate the MessagePublisherController with (EnableBinding(@Source.class))
   Autowire it and then use it to send the message to the exchange created as specified in the "application.properties" file.
   spring.cloud.stream.bindings.output.destination=commonexchange
5. Adding Service class Scheduler to enable the scheduling and enable the binding. Autowire the Source class
   to send the data and crete no argument scheduled method to execute it during application at particular intervals
   set in "fixedDelay". 
    