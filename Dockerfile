#build project
FROM maven:3.6.0-jdk-8-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean compile assembly:single

#create image
FROM openjdk:8-alpine
COPY --from=build /home/app/target/*.jar /home/app/telegram-bot.jar
WORKDIR /home/app
ENTRYPOINT ["java","-jar","/home/app/telegram-bot.jar"]