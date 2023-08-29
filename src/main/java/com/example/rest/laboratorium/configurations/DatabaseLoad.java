package com.example.rest.laboratorium.configurations;

import com.example.rest.laboratorium.repositories.CenarioRepositorio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseLoad {
    private static final Logger log = LoggerFactory.getLogger(DatabaseLoad.class);

    @Bean
    CommandLineRunner init(CenarioRepositorio cenarioRepositorio) {
        return args -> {
            log.info("Documentação em http://localhost:8080/swagger-ui/index.html");
        };
    }
}
