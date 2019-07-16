package com.assign.thesaurus.web;

import com.assign.thesaurus.service.ThesaurusService;
import com.assign.thesaurus.util.Mappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = Mappings.WORDS)
public class IThesaurusController {

    @Autowired
    ThesaurusService service;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addSynonyms(@RequestBody List<String> synonyms) {
        service.addSynonyms(synonyms);
    }

    @GetMapping(value = "/{"+ Mappings.Singular.WORD +"}")
    @ResponseBody
    public ResponseEntity<List<String>> getSynonyms(@PathVariable String word) {
        List<String> synonymList = service.getSynonyms(word);
        if (synonymList == null) {
            throw new ResourceNotFoundException("Synonym not found for :: " + word);
        }
        return ResponseEntity.ok().body(synonymList);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<String> getWords() {
        return service.getWords();
    }
}
