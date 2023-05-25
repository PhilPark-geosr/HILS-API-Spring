FROM openjdk:18.0.2-jdk
COPY build/libs/springppark-0.0.1-SNAPSHOT.jar springppark.jar
EXPOSE 8000
ENTRYPOINT exec java -jar springppark.jar