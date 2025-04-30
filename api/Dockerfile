FROM gradle:8.5.0-jdk17 AS build
WORKDIR /home/gradle/project

COPY . /home/gradle/project

RUN gradle build -x test

FROM eclipse-temurin:17-jre

COPY --from=build /home/gradle/project/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]
