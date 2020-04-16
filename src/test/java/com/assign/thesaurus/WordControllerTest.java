package com.assign.thesaurus;

import com.assign.thesaurus.persistence.model.Word;
import com.assign.thesaurus.spring.ThesaurusApplication;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { ThesaurusApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class WordControllerTest {

    private static final String API_ROOT = "http://localhost:8686/words";

    @Test
    public void whenGetAll_thenOK() {
        final Response response = RestAssured.get(API_ROOT);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }

    @Test
    public void whenGetCreatedById_thenOK() {
        final Word word = createRandomWord();
        final String location = createWordAsUri(word);

        System.out.println(location);

        final Response response = RestAssured.get(location);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertEquals(Arrays.asList(word.getSynonyms().split(",")).size(),
                Arrays.asList(response.body().print().split(",")).size());
    }

    @Test
    public void whenGetNotExistByName_thenNotFound() {
        final Response response = RestAssured.get(API_ROOT + "/" + randomAlphabetic(10));
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
    }

    @Test
    public void whenCreateNew_thenCreated() {
        final Word word = createRandomWord();

        String[] synonyms = word.getSynonyms().split(",");
        List<String> synonymList = new ArrayList<>();
        synonymList.add(word.getName());
        synonymList.addAll(Arrays.asList(synonyms));

        final Response response = RestAssured.given().contentType(MediaType.APPLICATION_JSON_VALUE).body(synonymList)
                .post(API_ROOT);

        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
    }

    // ===============================

    private Word createRandomWord() {
        Word word = new Word();
        word.setName(randomAlphabetic(10));
        List<String> synonyms = new ArrayList<>();
        for (int i = 0; i < word.getName().toCharArray().length; i++) {
            synonyms.add(randomAlphabetic(10));
        }
        word.setSynonyms(String.join(",", synonyms));
        return word;
    }

    private String createWordAsUri(Word word) {

        String[] synonyms = word.getSynonyms().split(",");
        List<String> synonymList = new ArrayList<>();
        synonymList.add(word.getName());
        synonymList.addAll(Arrays.asList(synonyms));

        final Response response = RestAssured.given().contentType(MediaType.APPLICATION_JSON_VALUE).body(synonymList)
                .post(API_ROOT);

        return API_ROOT + "/" + word.getName();
    }
}
