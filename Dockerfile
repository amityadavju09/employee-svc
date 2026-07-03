# Use an official runtime variant as a base image
FROM eclipse-temurin:17-jdk-jammy

# Set the internal working directory
WORKDIR /app

# Copy the built JAR file into the container
# For Maven:
COPY target/*.jar app.jar

# For Gradle (Uncomment below and comment out the Maven line if using Gradle):
# COPY build/libs/*.jar app.jar

# Inform Docker that the container listens on port 8080
EXPOSE 8080

# Command to execute the application
ENTRYPOINT ["java", "-jar", "app.jar"]