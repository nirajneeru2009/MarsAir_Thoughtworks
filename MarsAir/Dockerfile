# Use a base image with Java pre-installed
FROM openjdk:11-jdk-slim

# Install necessary tools and browsers for Selenium
RUN apt-get update && apt-get install -y git

# Set the working directory inside the container
WORKDIR /MarsAir

# Copy your project files into the container
RUN git clone https://github.com/nirajneeru2009/MarsAir_Thoughtworks.git /MarsAir

# Install dependencies using Maven or Gradle (if applicable)
RUN apt-get install -y maven && mvn clean install

# Set environment variables for Selenium WebDriver
ENV DISPLAY=:99

# Default command to run your Selenium tests
CMD ["mvn", "test"]
