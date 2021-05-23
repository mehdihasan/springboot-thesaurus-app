# Simple Thesaurus app

## Prerequisite (to build and run)

- you need to have [docker](https://docs.docker.com/install/) installed on your machine
- you need to have [docker-compose](https://docs.docker.com/compose/install/) install on your machine

## Build process

- clone the repo
- make sure Docker is running on your machine running the following command:

```bash
docker --version
```

- Run the following command to build the image

```bash
docker image build -t thesaurus https://github.com/mehdihasan/springboot-thesaurus-app.git
```

OR, you can clone the github repo. Then go to the root directory of the project and run the following command to build the image

```bash
docker image build -t thesaurus .
```

- then run the following command to make your container and run the app into port 8686

```bash
docker run --rm -d --name thesaurusApp -p 8686:8686 thesaurus
```

## Play

- View all words:
  you can go to your browser and surf [this](http://localhost:8686/words) url or run the following command:

```bash
curl http://localhost:8686/words | python -m json.tool
```

- View synonyms against any word
  you can go to your browser and surf [this](http://localhost:8686/words/amber) url or run the following command:

```bash
curl http://localhost:8686/words/amber | python -m json.tool
```

- Create new Word / Synonym

```bash
curl -i -X POST -H "Content-Type:application/json" http://localhost:8686/words -d '["logic", "description", "philosophy", "rationale", "sanity", "sense", "argumentation", "coherence"]'
```

Or you can use postman.

## Uninstall the project

To uninstall the project, please run the following command:

```bash
docker stop thesaurusApp
```

## Next
1. [10 best practices to build a Java container with Docker](https://snyk.io/blog/best-practices-to-build-java-containers-with-docker/)
   - **[OK]** Use explicit and deterministic Docker base image tags 
   - Install only what you need in production in the Java container image
   - Find and fix security vulnerabilities in your Java Docker image
   - **[OK]** Use multi-stage builds 
   - Don’t run Java apps as root 
   - Properly handle events to safely terminate a Java application 
   - Gracefully tear down Java applications 
   - Use `.dockerignore` 
   - Make sure Java is container-aware 
   - Be careful with automatic Docker container generation tools