FROM openjdk:11-jdk-alpine

COPY ./adapter/build/libs/adapter-0.0.1-SNAPSHOT.jar app.jar
CMD ["java","-jar","-Dspring.profiles.active=prod", "/app.jar"]

EXPOSE 8080