# Spring-Boot-Microservices

This Application demonstrate Microservice architecture.

We have 2 main microservice:

  1. Currecy Conversion
  2. Currency Exchange

We are using **Eureka** for service discovery. Both main microservices are registered with Eureka.

Also we are using **Spring Cloud API Gateway** which is also regsitered with Eureka.

**Zipkin** is used for Monitoring of microservice Endpoints.

**Docker-compose** file contains instruction to bulid and up the microservices.

# Architecture

![Microservice Architecture](https://user-images.githubusercontent.com/21008846/192539428-b2efa374-aa81-4f50-8fe0-b43805723aee.png)


## URLS

#### Currency Exchange Service
- http://localhost:8000/currency-exchange/from/USD/to/INR

#### Currency Conversion Service
- http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10
- http://localhost:8100/currency-conversion-feign/from/USD/to/INR/quantity/10

#### Eureka
- http://localhost:8761/

#### Zipkin
- http://localhost:9411/

#### API GATEWAY
- http://localhost:8765/currency-exchange/from/USD/to/INR
- http://localhost:8765/currency-conversion/from/USD/to/INR/quantity/10
- http://localhost:8765/currency-conversion-feign/from/USD/to/INR/quantity/10
- http://localhost:8765/currency-conversion-new/from/USD/to/INR/quantity/10


# Below is the steps to run the application on your local system.

1. Download this complete repository.
2. Open this project in your IDE.
3. Go to terminal and execute below command.

```
docker-compose up
```

# Screenshot

![Screenshot 2022-09-27 at 12 08 30 PM](https://user-images.githubusercontent.com/21008846/198861777-81138eac-a53a-469c-875c-568a4c300143.png)

![Screenshot 2022-09-27 at 12 09 35 PM](https://user-images.githubusercontent.com/21008846/198861789-1b9dd6d8-6c1f-43be-8d97-ea495fc60f2e.png)

![Screenshot 2022-09-27 at 12 09 13 PM](https://user-images.githubusercontent.com/21008846/198861795-2424dbe0-4394-4210-9e5a-28404635d2fb.png)

![Screenshot 2022-09-27 at 12 10 10 PM](https://user-images.githubusercontent.com/21008846/198861798-21b1227f-151f-4b23-938d-712002a863bc.png)
