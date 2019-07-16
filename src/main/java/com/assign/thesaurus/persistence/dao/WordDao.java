package com.assign.thesaurus.persistence.dao;

import com.assign.thesaurus.interfaces.IByNameApi;
import com.assign.thesaurus.persistence.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WordDao
        extends JpaRepository<Word, Long>
        , JpaSpecificationExecutor<Word>, IByNameApi<Word> {
}
