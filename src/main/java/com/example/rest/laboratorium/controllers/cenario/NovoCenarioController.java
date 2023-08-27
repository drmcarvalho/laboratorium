package com.example.rest.laboratorium.controllers.cenario;

import com.example.rest.laboratorium.commons.resposta.GerarRespostaBadRequest;
import com.example.rest.laboratorium.models.Cenario;
import com.example.rest.laboratorium.commons.validador.CampoVazio;
import com.example.rest.laboratorium.repositories.cenario.CenarioRepositorio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NovoCenarioController {

    public final CenarioRepositorio repositorio;

    public NovoCenarioController(CenarioRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @PostMapping("/api/cenarios")
    ResponseEntity<?> action(@RequestBody Cenario cenario) {
        if (CampoVazio.validar(cenario.getTitulo())) {
            return GerarRespostaBadRequest.resposta("Error de campo", "Forneça um titulo para o cenario");
        }
        if (CampoVazio.validar(cenario.getDescricao())) {
            return GerarRespostaBadRequest.resposta("Error de campo", "Forneça uma descrição para o cenario");
        }


        return ResponseEntity.ok(repositorio.save(cenario));
    }
}
