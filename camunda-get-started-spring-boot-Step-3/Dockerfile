# Use a Java runtime as a base image
FROM openjdk:17-jdk-slim

# Set the working directory to /app
WORKDIR /app

# Copy the Spring Boot application JAR file into the container at /app
COPY target/loan-approval-spring-boot-0.0.1-SNAPSHOT.jar /app

# Expose port 8080 to the outside world
EXPOSE 8085

# Run the Spring Boot application when the container starts
CMD ["java", "-jar", "loan-approval-spring-boot-0.0.1-SNAPSHOT.jar"]
