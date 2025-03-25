FROM openjdk:22
COPY target/GestaoTransporte0.2-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]