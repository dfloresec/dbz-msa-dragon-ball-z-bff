FROM openjdk:17-jdk-slim-buster
VOLUME /tmp
ENV client_secret=secreto
EXPOSE 9090
ADD ./build/libs/dbz-msa-dragon-ball-z-bff-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT [ "java" , "-jar", "/app.jar"]