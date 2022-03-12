FROM openjdk:11

USER root

ADD /target/crud-0.0.1.jar /app.jar

EXPOSE 8080

CMD java -jar /app.jar