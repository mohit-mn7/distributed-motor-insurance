FROM openjdk:8-jre-alpine
COPY target/dodgydrivers-0.0.1-SNAPSHOT.jar /dodgydrivers.jar
CMD java -jar /dodgydrivers.jar service.dodgydrivers.Application ${HOSTNAME}