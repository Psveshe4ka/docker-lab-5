FROM maven:3.9.5-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/docker-lab-5-1.0-SNAPSHOT.jar app.jar

ENV PRINCIPAL=10000
ENV RATE=10
ENV YEARS=5

CMD ["java", "-jar", "app.jar"]