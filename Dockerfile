FROM openjdk:latest
COPY ./target/SEMcoursework-0.1.0.2-jar-with-dependencies.jar /app/SEMcoursework.jar
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "/app/SEMcoursework.jar"]

