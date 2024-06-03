# Stage 1: Build the application
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/mediawave-0.0.1-SNAPSHOT.jar mediawave.jar

# Ensure the required directory exists and copy the service account key

# Expose the port and set the entrypoint
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "mediawave.jar"]
