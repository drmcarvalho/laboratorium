package com.example.rest.laboratorium.controllers.entrada;

import com.example.rest.laboratorium.commons.resposta.GerarRespostaBadRequest;
import com.example.rest.laboratorium.commons.validador.CampoVazio;
import com.example.rest.laboratorium.models.Entrada;
import com.example.rest.laboratorium.models.EntradaModelAssembler;
import com.example.rest.laboratorium.repositories.EntradaRepositorio;
import com.example.rest.laboratorium.repositories.TesteRepositorio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NovaEntradaController {

    private final EntradaRepositorio entradaRepositorio;
    private final TesteRepositorio testeRepositorio;
    private final EntradaModelAssembler modelAssembler;

    public NovaEntradaController(
            EntradaRepositorio entradaRepositorio,
            TesteRepositorio testeRepositorio,
            EntradaModelAssembler modelAssembler) {
        this.entradaRepositorio = entradaRepositorio;
        this.testeRepositorio = testeRepositorio;
        this.modelAssembler = modelAssembler;
    }

    @PostMapping("/api/entradas")
    public ResponseEntity<?> action(@RequestBody Entrada entrada) {
        if (CampoVazio.validar(entrada.getConteudo()))
            return GerarRespostaBadRequest.resposta("Campo error", "Informe o conteudo para a entrada");
        if (!testeRepositorio.findById(entrada.getIdTeste()).isPresent())
            return GerarRespostaBadRequest.resposta("Campo error", "O teste informado nao existe");


        return ResponseEntity.ok(modelAssembler.toModel(entradaRepositorio.save(entrada)));
    }
}
