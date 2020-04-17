FROM maven:3.6.0-jdk-8 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean install -DskipTests

FROM openjdk:8
COPY --from=build /usr/src/app/target/thesaurus-api-app.jar /usr/app/thesaurus-api-app.jar
EXPOSE 8686
ENTRYPOINT ["java","-jar","/usr/app/thesaurus-api-app.jar"]