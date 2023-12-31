package com.example.rest.laboratorium.controllers.teste;

import com.example.rest.laboratorium.commons.resposta.GerarRespostaBadRequest;
import com.example.rest.laboratorium.models.TesteModelAssembler;
import com.example.rest.laboratorium.models.enums.TesteSituacao;
import com.example.rest.laboratorium.repositories.TesteRepositorio;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings({"unused", "ClassCanBeRecord"})
@RestController
@Tag(name = "Testes")
public class DefinirTesteComoOkController {

    private final TesteRepositorio repositorio;
    private final TesteModelAssembler modelAssembler;

    public DefinirTesteComoOkController(TesteRepositorio repositorio, TesteModelAssembler modelAssembler) {
        this.repositorio = repositorio;
        this.modelAssembler = modelAssembler;
    }

    @PatchMapping("/api/testes/teste_ok/{id}")
    public ResponseEntity<?> action(@PathVariable Long id) {
        if (!repositorio.findById(id).isPresent()) {
            return GerarRespostaBadRequest.resposta("Campo error", "Teste nao foi encontrado");
        }

        return ResponseEntity.ok(repositorio.findById(id).map(teste -> {
            teste.setTesteSituacao(TesteSituacao.TESTE_OK);
            return modelAssembler.toModel(repositorio.save(teste));
        }));
    }
}
