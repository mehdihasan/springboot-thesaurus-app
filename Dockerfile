FROM maven:3.6.0-jdk-8 AS build
WORKDIR /usr/src/app
COPY src ./src
COPY pom.xml .
RUN mvn clean package -DskipTests


FROM openjdk:8 AS deploy
WORKDIR /app
COPY --from=build /usr/src/app/target/thesaurus-api-app.jar .
EXPOSE 8686
ENTRYPOINT ["java","-jar","/app/thesaurus-api-app.jar"]
#CMD ["--spring.profiles.active=postgres"]