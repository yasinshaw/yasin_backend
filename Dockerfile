FROM openjdk:11-jre-alpine

ENV NODE_ENV=production
ENV HOST 0.0.0.0

COPY ./adapter/build/libs/adapter-0.0.1-SNAPSHOT.jar app.jar
CMD ["java","-jar","/app.jar"]

EXPOSE 8080