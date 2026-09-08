FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Nur die Backend-Dateien kopieren
COPY backend/. .

# Maven Wrapper vom Hauptverzeichnis kopieren
COPY mvnw /app/mvnw
COPY mvnw.cmd /app/mvnw.cmd
COPY .mvn /app/.mvn

RUN chmod +x mvnw
RUN ./mvnw clean install

EXPOSE 8080

CMD ["java", "-jar", "target/*.jar"]