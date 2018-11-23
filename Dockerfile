FROM maven:3.6-jdk-11-slim as builder

RUN mkdir -p /opt/springboot
COPY src /opt/springboot/src
COPY pom.xml /opt/springboot/

RUN mvn -f /opt/springboot/pom.xml clean package

FROM openjdk:11-jdk-slim
EXPOSE 8080
RUN mkdir -p /opt/run
COPY --from=builder /opt/springboot/target/*.jar /opt/run
CMD java -jar /opt/run/*.jar
