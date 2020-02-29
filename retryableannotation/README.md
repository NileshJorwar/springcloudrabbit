# @Retryable annotation
1. Make sure to add aop, web, cloud dependencies
2. Call the controller with @EnableRetry annotation 
   and method with @Retryable and call methods implementing the retryable logic.
3. Call the recover method with @Recover annotation to catch the exceptions in case of failure.
4. Retryable annotation does not work to reestablish database connection hence used @Scheduling. 
