FROM openjdk:8-jre-alpine
COPY target/girlpower-0.0.1-SNAPSHOT.jar /girlpower.jar
CMD java -jar /girlpower.jar service.girlpower.Application ${HOSTNAME}