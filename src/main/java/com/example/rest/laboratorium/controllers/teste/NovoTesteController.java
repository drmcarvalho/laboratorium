package com.example.rest.laboratorium.controllers.teste;

import com.example.rest.laboratorium.commons.resposta.GerarRespostaBadRequest;
import com.example.rest.laboratorium.commons.validador.CampoVazio;
import com.example.rest.laboratorium.models.Teste;
import com.example.rest.laboratorium.models.TesteModelAssembler;
import com.example.rest.laboratorium.repositories.CenarioRepositorio;
import com.example.rest.laboratorium.repositories.TesteRepositorio;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings({"unused", "ClassCanBeRecord"})
@RestController
@Tag(name = "Testes")
public class NovoTesteController {

    private final TesteRepositorio testeRepositorio;
    private final CenarioRepositorio cenarioRepositorio;
    private final TesteModelAssembler modelAssembler;

    public NovoTesteController(
            TesteRepositorio testeRepositorio,
            CenarioRepositorio cenarioRepositorio,
            TesteModelAssembler modelAssembler) {
        this.testeRepositorio = testeRepositorio;
        this.cenarioRepositorio = cenarioRepositorio;
        this.modelAssembler = modelAssembler;
    }

    @PostMapping("/api/testes")
    public ResponseEntity<?> action(@RequestBody Teste teste) {
        if (CampoVazio.validar(teste.getTitulo()))
            return GerarRespostaBadRequest.resposta("Error campo", "Forneca um titulo para o teste");
        if (CampoVazio.validar(teste.getDescricao()))
            return GerarRespostaBadRequest.resposta("Error campo", "Forneca uma descricao para o teste");
        if (teste.getIdCenario() == null)
            return GerarRespostaBadRequest.resposta("Erro campo", "Forneca um idCenario para o teste");
        if (!cenarioRepositorio.findById(teste.getIdCenario()).isPresent())
            return GerarRespostaBadRequest.resposta("Error campo", "Cenario nao encontrado");


        return ResponseEntity.ok(modelAssembler.toModel(testeRepositorio.save(teste)));
    }
}
