package com.assign.thesaurus.interfaces;

import java.util.List;

public interface IThesaurus {

    /// <summary>
    /// Adds the given words as synonyms to each other /// </summary>
    public void addSynonyms(List<String> synonyms);

    /// <summary>
    /// Gets the synonyms for a word
    /// </summary>
    public List<String> getSynonyms(String word);

    /// <summary>
    /// Gets all words that are stored in the thesaurus /// </summary>
    public List<String> getWords();
}
