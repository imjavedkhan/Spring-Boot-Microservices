FROM openjdk:17-alpine
COPY target/*.jar currency-conversion.jar
EXPOSE 8100
ENTRYPOINT ["java", "-jar", "/currency-conversion.jar"]