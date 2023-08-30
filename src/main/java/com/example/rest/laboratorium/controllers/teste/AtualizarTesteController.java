package com.example.rest.laboratorium.controllers.teste;

import com.example.rest.laboratorium.commons.resposta.GerarRespostaBadRequest;
import com.example.rest.laboratorium.commons.validador.CampoVazio;
import com.example.rest.laboratorium.models.Teste;
import com.example.rest.laboratorium.models.TesteModelAssembler;
import com.example.rest.laboratorium.repositories.CenarioRepositorio;
import com.example.rest.laboratorium.repositories.TesteRepositorio;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings({"unused", "ClassCanBeRecord"})
@Tag(name = "Testes")
@RestController
public class AtualizarTesteController {
    private final TesteRepositorio testeRepositorio;
    private final CenarioRepositorio cenarioRepositorio;
    private final TesteModelAssembler modelAssembler;

    public AtualizarTesteController(
            TesteRepositorio testeRepositorio,
            CenarioRepositorio cenarioRepositorio,
            TesteModelAssembler modelAssembler) {
        this.testeRepositorio = testeRepositorio;
        this.cenarioRepositorio = cenarioRepositorio;
        this.modelAssembler = modelAssembler;
    }

    public ResponseEntity<?> action(@RequestBody Teste teste, @PathVariable Long id) {
        if (CampoVazio.validar(teste.getTitulo())) {
            return GerarRespostaBadRequest.resposta("Error de campo", "Forneça um titulo para o teste");
        }
        if (CampoVazio.validar(teste.getDescricao())) {
            return GerarRespostaBadRequest.resposta("Error de campo", "Forneça uma descrição para o teste");
        }
        if (!cenarioRepositorio.findById(teste.getIdCenario()).isPresent())
            return GerarRespostaBadRequest.resposta("Error de campo", "O cenario id especificado nao existe");


        return ResponseEntity.ok(testeRepositorio.findById(id)
                .map(testeAlteracao -> {
                    testeAlteracao.setTesteSituacao(teste.getTesteSituacao());
                    testeAlteracao.setTitulo(teste.getTitulo());
                    testeAlteracao.setDescricao(teste.getDescricao());
                    testeAlteracao.setIdCenario(teste.getIdCenario());
                    return modelAssembler.toModel(testeRepositorio.save(teste));
                })
                .orElseGet(() -> {
                    teste.setId(id);
                    return modelAssembler.toModel(testeRepositorio.save(teste));
                })
        );
    }
}
