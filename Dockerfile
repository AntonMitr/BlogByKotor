FROM openjdk:17

WORKDIR /app

COPY config/target/config-0.0.1-SNAPSHOT.jar app/config-0.0.1-SNAPSHOT.jar
COPY controller/target/controller-0.0.1-SNAPSHOT.jar app/controller-0.0.1-SNAPSHOT.jar
COPY dto/target/dto-0.0.1-SNAPSHOT.jar app/dto-0.0.1-SNAPSHOT.jar
COPY exception/target/exception-0.0.1-SNAPSHOT.jar app/exception-0.0.1-SNAPSHOT.jar
COPY mapper/target/mapper-0.0.1-SNAPSHOT.jar app/mapper-0.0.1-SNAPSHOT.jar
COPY model/target/model-0.0.1-SNAPSHOT.jar app/model-0.0.1-SNAPSHOT.jar
COPY repository/target/repository-0.0.1-SNAPSHOT.jar app/repository-0.0.1-SNAPSHOT.jar
COPY service/target/service-0.0.1-SNAPSHOT.jar app/service-0.0.1-SNAPSHOT.jar
COPY starter/target/starter-0.0.1-SNAPSHOT.jar app/starter-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app/starter-0.0.1-SNAPSHOT.jar"]

