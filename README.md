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
- go to the root directory of the project and run the following command to build the image 
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
