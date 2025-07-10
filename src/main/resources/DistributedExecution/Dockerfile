#FROM selenium/hub:latest

# Set the working directory to the desired location
#WORKDIR /opt/selenium

# Copy the selenium-server.jar file to the working directory
#COPY selenium-server.jar .

# Set permissions for the JAR file (optional, depending on your needs)
#RUN chmod +x selenium-server.jar

#EXPOSE 4444

FROM selenium/hub:latest

WORKDIR /opt/selenium

# Copy a custom selenium-server.jar with your desired configuration
COPY selenium-server.jar .

EXPOSE 4444

ENTRYPOINT ["java", "-jar", "selenium-server.jar", "hub"]