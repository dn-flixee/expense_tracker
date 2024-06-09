FROM maven:3.9.7-eclipse-temurin-17 AS builder

RUN mkdir /mvn-out
COPY src /mvn-out/src
COPY pom.xml /mvn-out
WORKDIR /mvn-out
RUN mvn clean package		

FROM eclipse-temurin:17.0.11_9-jre-ubi9-minimal
COPY --from=builder /mvn-out/target/*.jar app.jar
ENTRYPOINT ["java","-Xms512m","-Xmx512m","-jar","/app.jar"]
