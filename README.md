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
- go to the root directory of the project and run the following 
```bash
docker-compose up --build
```

## Play

- View all words
```bash
curl http://localhost:8686/words | python -m json.tool
```
- View synonyms against any word
```bash
curl http://localhost:8686/words/amber | python -m json.tool
```
- Create new Word / Synonym
```bash
curl -i -X POST -H "Content-Type:application/json" http://localhost:8686/words -d '["logic", "description", "philosophy", "rationale", "sanity", "sense", "argumentation", "coherence"]'
```

## Uninstall the project

To uninstall the project, please run the following command:
```bash
docker stop thesaurus-api-app-container &&
docker stop thesaurus-db-container &&
docker rm thesaurus-db-container &&
docker rm thesaurus-api-app-container
```