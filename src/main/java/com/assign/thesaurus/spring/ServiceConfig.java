package com.assign.thesaurus.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.assign.thesaurus.service" })
public class ServiceConfig {

    public ServiceConfig() {
        super();
    }
}
