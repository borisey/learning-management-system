FROM maven:3.6.3-openjdk-17-slim

COPY ./ ./
COPY ./wait-for-it.sh ./wait-for-it.sh

RUN chmod +x ./wait-for-it.sh

RUN mvn clean package

EXPOSE 9090

ENTRYPOINT ["java","-jar","target/user-0.0.1-SNAPSHOT.jar"]