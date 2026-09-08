FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Nur die notwendigen Dateien kopieren
COPY pom.xml .
COPY src ./src

# Maven installieren (statt des fehlenden Wrappers)
RUN apk add --no-cache maven
RUN mvn clean install

EXPOSE 8080

CMD ["java", "-jar", "target/*.jar"]