FROM maven:3.6.3-openjdk-17-slim

COPY ./ ./

RUN mvn clean package

EXPOSE 8080

ENTRYPOINT ["java","-jar","target/client-0.0.1-SNAPSHOT.jar"]