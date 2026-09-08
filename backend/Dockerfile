FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Den gesamten backend-Ordner kopieren
COPY . .

# Sicherstellen, dass der Maven Wrapper ausführbar ist
RUN chmod +x mvnw

# Projekt bauen (Überspringt die Tests für Geschwindigkeit)
RUN ./mvnw clean install -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/*.jar"]