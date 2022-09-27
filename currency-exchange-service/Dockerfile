FROM openjdk:17-alpine
COPY target/*.jar currency-exchange.jar
EXPOSE 8000
ENTRYPOINT ["java", "-jar", "/currency-exchange.jar"]