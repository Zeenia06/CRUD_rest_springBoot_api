FROM openjdk:17

# Copy the JAR file into the container
COPY target/task2-0.0.1-SNAPSHOT.jar task2-0.0.1-SNAPSHOT.jar

# Expose the port that the Spring Boot app will run on
EXPOSE 8081

# Command to run the application
CMD ["java", "-jar", "/task2-0.0.1-SNAPSHOT.jar"]
