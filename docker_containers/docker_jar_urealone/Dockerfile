# Start with a base image containing Java runtime

FROM ubuntu:18.04
WORKDIR /home/anthonypereira/IES_VM/docker_jar_urealone
# Install OpenJDK-8
RUN apt-get update && \
    apt-get install -y openjdk-11-jdk && \
    apt-get install -y ant && \
    apt-get clean;

# Fix certificate issues
RUN apt-get update && \
    apt-get install ca-certificates-java && \
    apt-get clean && \
    update-ca-certificates -f;

# Setup JAVA_HOME -- useful for docker commandline
ENV JAVA_HOME /usr/lib/jvm/java-11-openjdk-amd64/
RUN export JAVA_HOME
RUN apt-get update && \
  apt-get -y install sudo

COPY rooms_scanner .

# Add Maintainer Info
LABEL maintainer="anthonypereira"
RUN apt-get update -y && apt-get install maven -y
# Add a volume pointing to /tmp
VOLUME /tmp
# Make port 8080 available to the world outside this container
EXPOSE 8080
CMD ./mvnw spring-boot:run
