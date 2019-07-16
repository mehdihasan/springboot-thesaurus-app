package com.assign.thesaurus.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({ "com.assign.thesaurus.web" })
@EnableWebMvc
public class WebConfig {

    public WebConfig() {
        super();
    }
}
