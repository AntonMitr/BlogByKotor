FROM openjdk:17

WORKDIR /app

COPY starter/target/starter-0.0.1-SNAPSHOT.jar app/starter-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app/starter-0.0.1-SNAPSHOT.jar"]

