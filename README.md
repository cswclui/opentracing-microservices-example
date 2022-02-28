# opentracing-microservices-example

## Build docker images 

`bash ./docker-setup.sh`

## Launch the microservicse

`docker-compose up`

## Getting a random scientist name:

`curl -w "\n" http://localhost:8082/api/v1/scientists/random`

## Getting a random animal name:

`curl -w "\n"  http://localhost:8081/api/v1/animals/random`

## Getting a random animal and scientist name 

`curl -w "\n" http://localhost:8080/api/v1/names/random`

View the jaegar app.
http://localhost:9090

# Reference

This example microservice stack is adapted from 
- https://medium.com/xebia-engineering/jaeger-integration-with-spring-boot-application-3c6ec4a96a6f

Additional references
- https://shekhargulati.com/2019/04/08/a-minimalistic-guide-to-distributed-tracing-with-opentracing-and-jaeger/