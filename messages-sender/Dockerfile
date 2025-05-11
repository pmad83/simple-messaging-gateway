FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY build/libs/messages-sender-1.0.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
