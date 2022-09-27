FROM openjdk:17-alpine
COPY target/*.jar api-gateway.jar
EXPOSE 8765
ENTRYPOINT ["java", "-jar", "/api-gateway.jar"]