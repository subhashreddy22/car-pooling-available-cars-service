FROM openjdk:8
ADD target/available-cars-service.jar available-cars-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "available-cars-service.jar"]