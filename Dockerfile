FROM maven:3.9-eclipse-temurin-21 AS builder
WORKDIR /task
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk
RUN mkdir /task
WORKDIR /task
COPY --from=builder /task/target/*.jar /task/task.jar
CMD ["java", "-jar", "/task/task.jar"]
