# https://taes-k.github.io/2020/09/13/docker-2/ 참고

#FROM openjdk:8-jdk-alpine
FROM openjdk:11-jdk

EXPOSE 8150

MAINTAINER Lee HanSeok <sinabeuro53@naver.com>

VOLUME /tmp

ARG JAR_FILE=office_backend/build/libs/office_backend-1.0.0.jar
ADD ${JAR_FILE} app.jar
#COPY ${JAR_FILE} app.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "app.jar"]