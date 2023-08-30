package com.example.rest.laboratorium.controllers.cenario;

import com.example.rest.laboratorium.commons.resposta.GerarRespostaBadRequest;
import com.example.rest.laboratorium.models.Cenario;
import com.example.rest.laboratorium.commons.validador.CampoVazio;
import com.example.rest.laboratorium.models.CenarioModelAssembler;
import com.example.rest.laboratorium.repositories.CenarioRepositorio;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings({"unused", "ClassCanBeRecord"})
@RestController
@Tag(name = "Cenarios")
public class NovoCenarioController {

    public final CenarioRepositorio repositorio;
    private final CenarioModelAssembler modelAssembler;

    public NovoCenarioController(CenarioRepositorio repositorio, CenarioModelAssembler modelAssembler) {
        this.repositorio = repositorio;
        this.modelAssembler = modelAssembler;
    }

    @PostMapping("/api/cenarios")
    public ResponseEntity<?> action(@RequestBody Cenario cenario) {
        if (CampoVazio.validar(cenario.getTitulo())) {
            return GerarRespostaBadRequest.resposta("Error de campo", "Forneça um titulo para o cenario");
        }
        if (CampoVazio.validar(cenario.getDescricao())) {
            return GerarRespostaBadRequest.resposta("Error de campo", "Forneça uma descrição para o cenario");
        }


        return ResponseEntity.ok(modelAssembler.toModel(repositorio.save(cenario)));
    }
}
