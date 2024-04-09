FROM adoptopenjdk/openjdk11:alpine-jre

LABEL authors="Hieu"

ARG JAR_FILE=target/spring-boot-web.jar

WORKDIR /opt/app

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

#$ cd docker-spring-boot
#$ mvn clean package
#$ java -jar target/spring-boot-web.jar
#
#  -> http://localhost:8080
#
#//dockerize
# mvn clean package
#// create a docker image
#$ docker build -t test-docker:1.0 .
#// run it
#$  docker run -d -p 8080:8080 -t test-docker:1.0
#
#  -> http://localhost:8080
