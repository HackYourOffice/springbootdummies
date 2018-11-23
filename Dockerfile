FROM maven:3.6-jdk-11-slim

RUN mkdir -p /opt/springboot
COPY src /opt/springboot/src
COPY pom.xml /opt/springboot/

RUN mvn -f /opt/springboot/pom.xml clean package

FROM openjdk:11-jdk-slim
COPY target/*.jar /opt/

EXPOSE 8080
CMD java -jar /opt/*.jar
