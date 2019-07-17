FROM openjdk:8
ADD target/thesaurus-api-app.jar thesaurus-api-app.jar
EXPOSE 8686
ENTRYPOINT ["java", "-jar", "thesaurus-api-app.jar"]