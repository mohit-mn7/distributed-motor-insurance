FROM openjdk:8-jre-alpine
COPY target/broker-0.0.1-SNAPSHOT.jar /broker.jar
CMD java -jar /broker.jar service.broker.Application ${HOSTNAME}