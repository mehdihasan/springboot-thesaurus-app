package com.assign.thesaurus.spring;

import com.assign.thesaurus.service.ThesaurusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@SpringBootApplication
@Import({
        ContextConfig.class,
        PersistenceJpaConfig.class,
        ServiceConfig.class,
        WebConfig.class
})
public class ThesaurusApplication {

    @Autowired
    ThesaurusService service;

    public static void main(String[] args) {
        SpringApplication.run(ThesaurusApplication.class, args);
    }

    @Component
    public class DataSetup implements ApplicationRunner {

        @Override
        public void run(ApplicationArguments args) throws Exception {
            service.addSynonyms(Arrays.asList("engineer"
                    , "architect"
                    , "builder"
                    , "designer"
                    , "director"
                    , "inventor"
                    , "manager"
                    , "planner"
                    , "surveyor"
                    , "contriver"
                    , "deviser"
                    , "manipulator"
                    , "originator"
                    , "schemer"
                    , "sights"
                    , "techie"
                    , "technie"));
            service.addSynonyms(Arrays.asList("amber"
                    , "brown"
                    , "tan"
                    , "golden"
                    , "yellowish"));
        }
    }
}
