FROM java:latest
MAINTAINER tang
ARG JAR_FILE
ADD /target/${JAR_FILE} /docker_demo.jar
ENTRYPOINT ["java", "-jar", "/docker_demo.jar"]