package com.example.rest.laboratorium.controllers.testes;

import com.example.rest.laboratorium.commons.resposta.GerarRespostaBadRequest;
import com.example.rest.laboratorium.commons.validador.CampoVazio;
import com.example.rest.laboratorium.controllers.controlleradvice.RecursoNotFoundException;
import com.example.rest.laboratorium.models.Teste;
import com.example.rest.laboratorium.models.TesteModelAssembler;
import com.example.rest.laboratorium.repositories.cenario.CenarioRepositorio;
import com.example.rest.laboratorium.repositories.teste.TesteRepositorio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
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

    public ResponseEntity<?> action(@RequestBody Teste teste) {
        return cenarioRepositorio.findById(teste.getIdCenario())
                .map(cenario -> {
                    if (CampoVazio.validar(teste.getTitulo()))
                        return GerarRespostaBadRequest.resposta("Error campo", "Forneca um titulo para o teste");
                    if (CampoVazio.validar(teste.getDescricao()))
                        return GerarRespostaBadRequest.resposta("Error campo", "Forneca uma descricao para o teste");
                    return ResponseEntity.ok(modelAssembler.toModel(testeRepositorio.save(teste)));
                })
                .orElseThrow(() -> new RecursoNotFoundException(teste.getIdCenario(), "Cenario"));
    }
}
