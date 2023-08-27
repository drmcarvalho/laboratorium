package com.example.rest.laboratorium.dataload;

import com.example.rest.laboratorium.repositories.cenario.CenarioRepositorio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseLoad {
    private static final Logger log = LoggerFactory.getLogger(DatabaseLoad.class);

    @Bean
    CommandLineRunner initDatabase(CenarioRepositorio cenarioRepositorio) {
        return args -> {
            log.info("Init database teste");
        };
    }
}
