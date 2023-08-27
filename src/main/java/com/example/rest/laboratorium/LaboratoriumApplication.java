package com.example.rest.laboratorium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.rest.laboratorium.controllers")
@ComponentScan("com.example.rest.laboratorium.configurations")
@ComponentScan("com.example.rest.laboratorium.models")
public class LaboratoriumApplication {

	public static void main(String... args) {
		SpringApplication.run(LaboratoriumApplication.class, args);
	}
}
