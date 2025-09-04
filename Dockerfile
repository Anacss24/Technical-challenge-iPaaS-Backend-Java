FROM openjdk:21-jdk
RUN mkdir /task
WORKDIR /task
COPY target/*.jar /task/task.jar
CMD ["java", "-jar", "/task/task.jar"]

