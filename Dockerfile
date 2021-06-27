FROM adoptopenjdk/openjdk11:ubi
MAINTAINER Denzil Gideon M. Daulo
COPY target/backend-api-0.0.1-SNAPSHOT.jar backend-api.jar
CMD java -jar backend-api.jar