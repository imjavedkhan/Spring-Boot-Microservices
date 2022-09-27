FROM openjdk:17-alpine
COPY target/*.jar naming-server.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "/naming-server.jar"]