FROM openjdk:latest
COPY ./target/sem-coursework-0.1.0.2-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "sem-coursework-0.1.0.2-jar-with-dependencies.jar"]