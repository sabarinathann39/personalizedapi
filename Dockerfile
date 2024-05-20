# Use a base image with Java pre-installed
FROM  openjdk:21-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the executable JAR file into the container at /app
COPY target/personalizedservice-0.0.1-SNAPSHOT.jar /app/personalizedservice-0.0.1-SNAPSHOT.jar

# Expose the port the application runs on
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "personalizedservice-0.0.1-SNAPSHOT.jar"]
