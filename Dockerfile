FROM maven:3.6.0-jdk-8 AS build

LABEL maintainer="mail@mehdihasan.me"

COPY src /usr/src/app/src  
COPY pom.xml /usr/src/app

WORKDIR /usr/src/app

RUN mvn clean package -DskipTests

# FROM openjdk:8
#COPY --from=build /usr/src/app/target/thesaurus-api-app.jar /usr/app/thesaurus-api-app.jar
WORKDIR /usr/src/app

COPY target/thesaurus-api-app.jar /build/thesaurus-api-app.jar
EXPOSE 8686
ENTRYPOINT ["java","-jar","/build/thesaurus-api-app.jar"]
