package com.assign.thesaurus.service;

import com.assign.thesaurus.interfaces.IThesaurus;
import com.assign.thesaurus.persistence.dao.WordDao;
import com.assign.thesaurus.persistence.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class ThesaurusService implements IThesaurus {

    @Autowired
    private WordDao wordDao;

    public ThesaurusService() {
        super();
    }

    // find

    @Transactional(readOnly = true)
    public List<Word> getAll() {
        return wordDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> getWords() {
        List<String> words = new ArrayList<>();
        wordDao.findAll().forEach((w) -> words.add(w.getName()));
        return words;
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> getSynonyms(final String name) {
        Word word = wordDao.findByName(name);
        if (word == null) {
            return null;
        }
        String[] synonyms = word.getSynonyms().split(",");
        return Arrays.asList(synonyms);
    }

    // add

    @Override
    public void addSynonyms(List<String> entityList) {

        for (String wordString: entityList) {
            Word word = new Word();
            word.setName(wordString);

            ArrayList<String> subset = new ArrayList<>(entityList);
            subset.remove(wordString);
            word.setSynonyms(String.join(",", subset));

            wordDao.save(word);
        }
    }
}
