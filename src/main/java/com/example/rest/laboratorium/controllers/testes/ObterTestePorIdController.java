package com.example.rest.laboratorium.controllers.testes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObterTestePorIdController {

    @GetMapping("/api/testes/{id}")
    public ResponseEntity<?> action(Long id) {
        return null;
    }
}
