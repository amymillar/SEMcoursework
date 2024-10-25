FROM openjdk:latest
COPY ./target/semcoursework-0.1.0.2-jar-with-dependencies.jar /app/semcoursework.jar
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "/app/semcoursework.jar"]

