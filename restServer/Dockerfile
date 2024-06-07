# Etapa 1: Construir la aplicación con Maven
FROM maven:3.9-sapmachine-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Ejecutar la aplicación Java en una imagen más ligera
FROM openjdk:21-jdk-oracle
WORKDIR /app
COPY --from=build /app/target/restServer.jar /app/restServer.jar
ENTRYPOINT ["java", "-jar", "restServer.jar"]