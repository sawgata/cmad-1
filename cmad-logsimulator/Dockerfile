FROM maven:3.6.1-jdk-8-slim
WORKDIR /app
COPY .  .
RUN mvn package && \
    mv target/cmad-logsimulator-service.jar /run/logsimulator.jar && \
    rm -rf /app/*
CMD java  -jar /run/logsimulator.jar
