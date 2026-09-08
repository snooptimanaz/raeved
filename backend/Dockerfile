FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Maven installieren
RUN apk add --no-cache maven

# Nur die notwendigen Dateien kopieren
COPY pom.xml .
COPY src ./src

# Projekt bauen
RUN mvn clean install

EXPOSE 8080

# Genauen JAR-Namen angeben!
CMD ["java", "-jar", "target/raever-backend-1.0.0.jar"]