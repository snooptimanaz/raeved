FROM openjdk:17-jdk-slim

WORKDIR /app

COPY . .

RUN ./mvnw clean install

CMD ["java", "-jar", "target/*.jar"]