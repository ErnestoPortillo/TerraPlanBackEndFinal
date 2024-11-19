FROM amazoncorretto:21-alpine-jdk
MAINTAINER ERNESTO
COPY target/TerraPlan-0.0.1-SNAPSHOT.jar TerraPlan.jar
ENTRYPOINT ["java","-jar","/TerraPlan.jar"]