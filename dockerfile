# Use an OpenJDK base image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file into the container at /app
COPY target/mediawave-0.0.1-SNAPSHOT.jar /app/mediawave.jar

# Expose the port that the Spring Boot application will run on
EXPOSE 8080

# Run the Spring Boot application when the container launches
CMD ["java", "-jar", "mediawave.jar"]
