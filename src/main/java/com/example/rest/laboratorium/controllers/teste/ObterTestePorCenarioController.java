package com.example.rest.laboratorium.controllers.teste;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class ObterTestePorCenarioController {

    @GetMapping("/api/cenarios/testes/{idCenario}")
    public ResponseEntity<?> action(Long idCenario) {
        return null;
    }
}
