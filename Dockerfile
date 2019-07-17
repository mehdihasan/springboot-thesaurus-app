FROM openjdk:8
RUN /bin/bash -c "mvn clean install -DskipTests"
ADD target/thesaurus-api-app.jar thesaurus-api-app.jar
EXPOSE 8686
ENTRYPOINT ["java", "-jar", "thesaurus-api-app.jar"]