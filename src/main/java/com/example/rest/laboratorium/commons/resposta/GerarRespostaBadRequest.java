package com.example.rest.laboratorium.commons.resposta;

import org.springframework.hateoas.mediatype.problem.Problem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GerarRespostaBadRequest {

    public static ResponseEntity<?> resposta(String titulo, String descricao) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Problem.create().withTitle(titulo).withDetail(descricao));
    }
}
